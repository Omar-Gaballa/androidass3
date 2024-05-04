package com.example.assignment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MidFragment : Fragment() {

    var productName = ArrayList<String>()
    var productImage = ArrayList<Int>()
    var productPrice = ArrayList<Float>()


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MenuItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_mid, container, false)


        recyclerView = view.findViewById(R.id.menu)
        recyclerView.layoutManager=LinearLayoutManager(view.context)

        adapter = MenuItemAdapter(productName,productImage,productPrice,view.context)
        recyclerView.adapter = adapter



        productName.add("HP Victus 16")
        productName.add("Iphone")
        productName.add("Astro A40")
        productImage.add(R.drawable.victus)
        productImage.add(R.drawable.iphone)
        productImage.add(R.drawable.astro)

        productPrice.add(1000f)
        productPrice.add(200f)
        productPrice.add(300f)


        return view
    }


}