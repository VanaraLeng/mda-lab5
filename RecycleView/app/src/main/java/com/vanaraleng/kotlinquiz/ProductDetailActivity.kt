package com.vanaraleng.kotlinquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.product_item_list.tvDescription

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        (intent.getSerializableExtra("product") as Product).let { product ->

            ivProduct.setImageResource(product.imageRes)
            tvName.text = product.name
            tvDescription.text = product.description
            tvPrice.text = "$ ${product.price}"
        }

        btnHome.setOnClickListener { finish() }

    }
}