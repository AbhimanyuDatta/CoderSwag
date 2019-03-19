package com.android.me.coderswag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.android.me.coderswag.R
import com.android.me.coderswag.model.Category
import com.android.me.coderswag.util.DRAWABLE
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryAdapter(private val context: Context, private val categories: List<Category>) : BaseAdapter() {

    // called every time view is created, list is scrolled
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var categoryView: View
        val holder: ViewHolder
        if (null == convertView) {
            // inflate view once, for the first time
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.categoryImg
            holder.categoryName = categoryView.categoryName
            categoryView.tag = holder
        } else {
            // use previous holder
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }
        val category = categories[position]
        holder.categoryName?.text = category.title
        val resourceId = context.resources.getIdentifier(category.image, DRAWABLE, context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    // view holder to hold an recycle views
    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }

}