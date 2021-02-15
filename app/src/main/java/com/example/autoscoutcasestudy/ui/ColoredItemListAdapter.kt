package com.example.autoscoutcasestudy.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.autoscoutcasestudy.model.ColoredItems
import com.example.autoscoutcasestudy.R
import com.example.autoscoutcasestudy.databinding.ColoredItemListAdapterBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.FragmentScoped

import javax.inject.Inject

@FragmentScoped
class ColoredItemListAdapter @Inject constructor(
    @ApplicationContext val context: Context
) : RecyclerView.Adapter<ColoredItemListAdapter.ViewHolder>() {

    lateinit var bindAdapter: ColoredItemListAdapterBinding
    lateinit var onItemListener: OnItemClickListener
    var coloredItemsArrayList = ArrayList<ColoredItems>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.colored_item_list_adapter, parent, false)
        bindAdapter = ColoredItemListAdapterBinding.bind(view)
        return ViewHolder(view)
    }

    fun initialiseListener(
        listener: OnItemClickListener,
        coloredItemsList: List<ColoredItems>
    ) {
        coloredItemsArrayList.addAll(coloredItemsList)
        onItemListener = listener
        //notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val item = bindAdapter.item
        private val cardView = bindAdapter.cardView

        init {
            cardView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION)
                    onItemListener.onItemClick(coloredItemsArrayList[position].color)
            }
        }

        fun bindTo(position: Int) {
            item.text = coloredItemsArrayList[position].item.toString()
            cardView.setCardBackgroundColor(coloredItemsArrayList[position].color)
        }
    }

    override fun getItemCount(): Int {
        return coloredItemsArrayList.size
    }

    interface OnItemClickListener {
        fun onItemClick(colorCode: Int)
    }

}
