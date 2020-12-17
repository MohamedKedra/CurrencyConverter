package com.example.currencyconverter.ui.converter

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.currencyconverter.R
import kotlinx.android.synthetic.main.header_currency_layout.*

class ConverterFragment : Fragment() {

    private lateinit var viewModel: ConverterViewModel

    private fun initDropDownList() {
        val list = ArrayList<String>()
        list.add("EGP")
        list.add("EUR")
        list.add("DOL")
        list.add("ZWL")
        list.add("YEN")
        list.add("DEN")
        val adapter =
            ArrayAdapter(activity?.applicationContext!!, android.R.layout.simple_spinner_item, list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_currencies.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.converter_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ConverterViewModel::class.java)
        initDropDownList()
    }

}