package com.example.assignment3

import android.health.connect.datatypes.TotalCaloriesBurnedRecord
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TopFragment : Fragment() {
companion object {
    var cartNameList = ArrayList<String>()
    var cartImageList = ArrayList<Int>()
    var cartPriceList = ArrayList<Float>()
    var cartquantity = ArrayList<Int>()
    lateinit var adapter: ProductAdapter
    lateinit var total:TextView
    lateinit var subtotal:TextView
}




    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_top, container, false)

        recyclerView=view.findViewById(R.id.cart_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        total = view.findViewById(R.id.Total)
        subtotal = view.findViewById(R.id.SubTotal)


        cartquantity.add(1)
        cartPriceList.add(1f)
        cartImageList.add(R.drawable.iphone)
        cartNameList.add("test")


        total.text = "0"
        subtotal.text = "0"



        adapter = ProductAdapter(cartNameList,cartImageList,cartPriceList, cartquantity,view.context)
        recyclerView.adapter = adapter


        return view
    }


}