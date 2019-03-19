package com.android.me.coderswag.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.android.me.coderswag.R
import com.android.me.coderswag.model.Product
import com.android.me.coderswag.util.DRAWABLE
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductAdapter(private val context: Context, private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProduct(context, products[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val productImg: ImageView? = itemView.productImg
        private val productName: TextView? = itemView.productName
        private val productPrice: TextView? = itemView.productPrice

        fun bindProduct(context: Context, product: Product) {
            val resourceId = context.resources.getIdentifier(product.image, DRAWABLE, context.packageName)
            productImg?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
        }

    }

}