package com.example.anmp160420137

data class Car(val make: String, val model: String, val year: Int, val color: String)


data class CarList(
    val cars: List<Car>
)
