package com.android.me.coderswag.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.android.me.coderswag.R
import com.android.me.coderswag.model.Category
import com.android.me.coderswag.util.DRAWABLE
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryRecycleAdapter(private val context: Context, private val categories: List<Category>, private val itemClick: (Category) -> Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.ViewHolder>() {

    // called when creating the view for the first time
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    // binding view with the item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCategory(context, categories[position])
    }

    inner class ViewHolder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val categoryImg: ImageView? = itemView.categoryImg
        private val categoryName: TextView? = itemView.categoryName

        fun bindCategory(context: Context, category: Category) {
            val resourceId = context.resources.getIdentifier(category.image, DRAWABLE, context.packageName)
            categoryImg?.setImageResource(resourceId)
            categoryName?.text = category.title

            // setting on click listener
            itemView.setOnClickListener { itemClick(category) }
        }

    }

}