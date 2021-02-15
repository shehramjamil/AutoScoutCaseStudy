package com.example.autoscoutcasestudy.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.autoscoutcasestudy.R
import com.example.autoscoutcasestudy.databinding.ColoredItemListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ColoredItemListFragment() : Fragment(R.layout.colored_item_list),
    ColoredItemListAdapter.OnItemClickListener {

    private var itemList = (0..100000).toList()

    private val viewModel by viewModels<ColoredItemViewModel>()

    @Inject
    lateinit var coloredItemListAdapter: ColoredItemListAdapter

    private var coloredItemListBinding: ColoredItemListBinding? = null
    private lateinit var coloredItemListRV: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = ColoredItemListBinding.bind(view)
        coloredItemListBinding = binding

        coloredItemListAdapter.initialiseListener(this, viewModel.mapItemToColor(itemList))

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        coloredItemListRV = coloredItemListBinding!!.recyclerView
        coloredItemListRV.adapter = coloredItemListAdapter
    }

    override fun onDestroy() {
        coloredItemListBinding = null
        super.onDestroy()
    }

    override fun onItemClick(colorCode: Int) {
        val action =
            ColoredItemListFragmentDirections.actionColoredItemListFragmentToColorFragment(colorCode)
        findNavController().navigate(action)
    }

}