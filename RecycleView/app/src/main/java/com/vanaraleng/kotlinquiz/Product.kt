package com.vanaraleng.kotlinquiz

import java.io.Serializable

data class Product (
    val name: String,
    val description: String,
    val price: Double,
    val imageRes: Int,
    val logoRes: Int,
): Serializable