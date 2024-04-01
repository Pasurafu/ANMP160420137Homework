package com.example.anmp160420137

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

import com.example.anmp160420137.Car


class CarListFragment : Fragment() {
    private lateinit var carAdapter: CarAdapter
    private lateinit var carListViewModel: CarListViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi adapter RecyclerView
        carAdapter = CarAdapter()

        // Atur RecyclerView dengan adapter
        recyclerView.adapter = carAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Inisialisasi ViewModel
        carListViewModel = ViewModelProvider(this).get(CarListViewModel::class.java)

        // Observasi LiveData dari ViewModel
        carListViewModel.carListLiveData.observe(viewLifecycleOwner, Observer { carList ->
            // Ketika data berubah, update adapter RecyclerView
            carAdapter.submitList(carList)
        })

        // Mulai memuat data dari JSON
        carListViewModel.loadDataFromJson("http://localhost:8000/cars.json") // Ganti dengan URL yang sesuai
    }
}

