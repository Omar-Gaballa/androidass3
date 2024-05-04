package com.example.assignment3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    var productNames: ArrayList<String>,
    var productImages: ArrayList<Int>,
    var productPrices: ArrayList<Float>,
    var productQuantity: ArrayList<Int>,
    var context: Context):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()
{


    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var textProductName:TextView=itemView.findViewById(R.id.product_name)
        var textProductPrice:TextView=itemView.findViewById(R.id.Product_Price)
        var Product_Image:ImageView=itemView.findViewById(R.id.Product_Image)
        var productQuantityText:TextView = itemView.findViewById(R.id.prod_quant)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_design,parent,false)

        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productNames.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.textProductName.text = productNames.get(position)
        holder.Product_Image.setImageResource(productImages.get(position))
        holder.textProductPrice.text = productPrices.get(position).toString() + "$"
        holder.productQuantityText.text = productQuantity.get(position).toString()


    }
}