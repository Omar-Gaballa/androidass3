package com.example.assignment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class BotFragment : Fragment() {

    companion object {
        lateinit var itemImage: ImageView
        lateinit var itemName: TextView
        lateinit var itemPrice: TextView
        lateinit var quantity: TextView
    }

    var tot:Int = 0
    lateinit var plusButton:Button
    lateinit var minusButton:Button
    lateinit var addToCartButton:Button




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bot, container, false)

        itemName= view.findViewById(R.id.productName)
        itemImage= view.findViewById(R.id.productImage)
        itemPrice= view.findViewById(R.id.productPrice)
        quantity= view.findViewById(R.id.quantity)


        plusButton= view.findViewById(R.id.plus_button)
        minusButton= view.findViewById(R.id.minus_button)
        addToCartButton= view.findViewById(R.id.addToCartButton)


        plusButton.setOnClickListener{
            quantity.text = (quantity.text.toString().toInt()+ 1) .toString()
        }

        minusButton.setOnClickListener{
            if (quantity.text.toString().toInt() > 1 ){
                quantity.text = (quantity.text.toString().toInt() - 1) .toString()
            }
        }

        addToCartButton.setOnClickListener{


            if(!TopFragment.cartNameList.contains(MainActivity.itname)) {
                TopFragment.cartImageList.add(MainActivity.itimage)
                TopFragment.cartNameList.add(MainActivity.itname)
                TopFragment.cartPriceList.add(MainActivity.itprice)
                TopFragment.cartquantity.add(quantity.text.toString().toInt())
                tot += MainActivity.itprice.toInt() * quantity.text.toString().toInt()
            }else{
                var i = TopFragment.cartNameList.indexOf(MainActivity.itname)
                TopFragment.cartquantity.set(i, TopFragment.cartquantity.get(i) + quantity.text.toString().toInt())
                tot+= TopFragment.cartPriceList.get(i).toInt() * quantity.text.toString().toInt()

            }


//            for(i in TopFragment.cartPriceList){
//                TopFragment.subtotal.text = (TopFragment.subtotal.text.toString().toFloat() + i).toString()
//            }
//            TopFragment.total.text = (TopFragment.subtotal.text.toString().toFloat() + 10f).toString()


            TopFragment.subtotal.text = tot.toString()
            TopFragment.total.text = (tot+10).toString()

            if(TopFragment.total.text.toString().toFloat() > 200){
                Toast.makeText(view.context,"your total has exceeded 200$", Toast.LENGTH_SHORT).show()
            }


            TopFragment.adapter.notifyDataSetChanged()


        }



        return view
    }


}