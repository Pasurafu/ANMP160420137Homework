package com.example.anmp160420137
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anmp160420137.Student

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONObject

class DetailViewModel: ViewModel() {
    // Week 7 Exercise
    val studentLD = MutableLiveData<Student>()
    fun fetchStudentDetail(studentId: String) {
        val url = "http://adv.jitusolution.com/student.php?id=$studentId"

        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->

                val gson = Gson()
                val studentDetail = gson.fromJson(response.toString(), StudentDetail::class.java)

            },
            { error ->

            }
        )


        Volley.newRequestQueue().add(request)
    }

}