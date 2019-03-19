package com.android.me.coderswag.controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.android.me.coderswag.R
import com.android.me.coderswag.adapter.ProductAdapter
import com.android.me.coderswag.service.DataService
import com.android.me.coderswag.util.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductAdapter(this, DataService.getProducts(categoryType))

        val orientation = resources.configuration.orientation

        var spanCount = when (orientation) {
            Configuration.ORIENTATION_PORTRAIT -> 2
            else -> 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)

        productListView.adapter = adapter
        productListView.layoutManager = layoutManager
    }
}
