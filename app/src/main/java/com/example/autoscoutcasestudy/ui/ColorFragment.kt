package com.example.autoscoutcasestudy.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.autoscoutcasestudy.R

class ColorFragment : Fragment(R.layout.color_fragment) {

    private val args: ColorFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(args.colorCode)
    }
}