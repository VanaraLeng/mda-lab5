package com.vanaraleng.kotlinquiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_item_list.view.*

class ProductAdapter(private var productList: ArrayList<Product>, var onItemClick: ((Product) -> Unit)? = null) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.MyViewHolder, position: Int) {
        holder.itemView.tvName.text = productList[position].name
        holder.itemView.tvDescription.text = productList[position].description
        holder.itemView.tvPrice.text = "$ ${productList[position].price}"
        holder.itemView.ivProduct.setImageResource(productList[position].imageRes)
        holder.itemView.ivLogo.setImageResource(productList[position].logoRes)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(productList[adapterPosition])
            }
        }
    }
}