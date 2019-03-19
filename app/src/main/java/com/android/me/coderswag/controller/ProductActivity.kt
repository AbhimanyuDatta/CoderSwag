package com.android.me.coderswag.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.me.coderswag.R
import com.android.me.coderswag.util.EXTRA_CATEGORY

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)
    }
}
