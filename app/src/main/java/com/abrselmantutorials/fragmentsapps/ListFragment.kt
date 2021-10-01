package com.abrselmantutorials.fragmentsapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*
import kotlin.collections.ArrayList


class ListFragment(val listClickToDetailsUpdater: ListClickToDetailsUpdater) : Fragment(),
    AdapterView.OnItemClickListener {
    private lateinit var listView: ListView
    val countries = ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = activity?.findViewById(R.id.listView) as ListView
        val locales: Array<Locale> = Locale.getAvailableLocales()
        for (locale in locales) {
            val country: String = locale.displayCountry
            if (country.trim { it <= ' ' }.isNotEmpty() && !countries.contains(country)) {
                countries.add(country)
            }
        }
        countries.sort()
        val adapter =
            ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, countries)
        listView.adapter = adapter
        listView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        listClickToDetailsUpdater.countrySelected(countries[position])
    }
}