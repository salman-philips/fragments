package com.abrselmantutorials.fragmentsapps


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), ListClickToDetailsUpdater {
    lateinit var leftFragment: ListFragment
    lateinit var rightFragment: DetailsFragment
    lateinit var leftContainer: FragmentContainerView
    lateinit var rightContainer: FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        leftContainer = findViewById(R.id.leftContainer)
        rightContainer = findViewById(R.id.rightContainer)
        leftFragment = ListFragment(this)
        rightFragment = DetailsFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.leftContainer, leftFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.rightContainer, rightFragment)
            .commit()
    }

    override fun countrySelected(country: String) {
        rightFragment.updateWithCountry(country)
    }
}