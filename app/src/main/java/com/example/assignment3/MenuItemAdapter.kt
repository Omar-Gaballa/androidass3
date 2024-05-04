package com.example.assignment3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MenuItemAdapter(
    var productNames: ArrayList<String>,
    var productImages: ArrayList<Int>,
    var productPrices: ArrayList<Float>,
    var context: Context): RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder>()
{
    class MenuItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var textProductName: TextView =itemView.findViewById(R.id.Menu_item_name)
        var textProductPrice: TextView =itemView.findViewById(R.id.Menu_Item_Price)
        var Product_Image: ImageView =itemView.findViewById(R.id.Menu_item_image)
        var cardview: CardView = itemView.findViewById(R.id.menu_cardview)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.menu_item_card,parent,false)

        return MenuItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productNames.size
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.textProductName.text = productNames.get(position)
        holder.Product_Image.setImageResource(productImages.get(position))
        holder.textProductPrice.text = productPrices.get(position).toString() + "$"

        holder.cardview.setOnClickListener{
            MainActivity.itname = productNames.get(position)
            MainActivity.itprice = productPrices.get(position)
            MainActivity.itimage = productImages.get(position)

            BotFragment.itemName.setText(MainActivity.itname)
            BotFragment.itemImage.setImageResource(MainActivity.itimage)
            BotFragment.itemPrice.setText("" + MainActivity.itprice + "$")
            BotFragment.quantity.setText("1")
        }
    }
}