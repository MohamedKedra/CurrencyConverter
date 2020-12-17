package com.example.currencyconverter.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.currencyconverter.R
import kotlinx.android.synthetic.main.header_currency_layout.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() ,OnItemClickedListener{

    private lateinit var viewModel: HomeViewModel

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

    private fun initList() {
        val adapter = CurrencyAdapter(this)
        rv_currency_list.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        initDropDownList()
        initList()
    }

    override fun onItemClicked(view: View) {
        findNavController().navigate(R.id.action_HomeFragment_to_ConverterFragment)
    }
}