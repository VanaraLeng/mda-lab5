package com.vanaraleng.kotlinquiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = ArrayList<Product>()
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0, R.drawable.ipad, R.drawable.apple))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00, R.drawable.macbook, R.drawable.apple))
        products.add(Product("Dell Inspiron", "13th Gen Intel® CoreTM i7", 1499.00, R.drawable.dell_inspiron, R.drawable.dell))
        products.add(Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00, R.drawable.logi_keyboard, R.drawable.logi))
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00, R.drawable.macbook, R.drawable.apple))

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProductAdapter(products)
        recyclerView.adapter = adapter

        adapter.onItemClick = { product ->
            startActivity(Intent(this, ProductDetailActivity::class.java).apply {
                putExtra("product", product)
            })
        }
    }

}
