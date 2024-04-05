package com.example.anmp160420137


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class CarListViewModel : ViewModel() {
    private val gson = Gson()
    private val jsonDataLoader = liveModel()
    private val _carListLiveData = MutableLiveData<List<Car>>()
    val carListLiveData: LiveData<List<Car>> = _carListLiveData

    fun loadDataFromJson(urlString: String) {
        thread {
            val jsonData = jsonDataLoader.loadDataFromJson(urlString)
            // Di sini Anda perlu menyesuaikan dengan cara parsing JSON dan mengonversinya menjadi objek Car
            val carList: List<Car> = parseJsonToCarList(jsonData)
            _carListLiveData.postValue(carList)
        }
    }

    // Metode untuk memparsir data JSON menjadi objek Car
    private fun parseJsonToCarList(jsonData: String): List<Car> {
        val jsonArray = JSONArray(jsonData)
 val carList = mutableListOf<Car>()
 for (i in 0 until jsonArray.length()) {
    val jsonObject = jsonArray.getJSONObject(i)
  val car = Car(
     make = jsonObject.getString("make"),
        model = jsonObject.getString("model"),
   year = jsonObject.getInt("year"),
      color = jsonObject.getString("color")
   )
    carList.add(car)
 }
return carList
    }}




