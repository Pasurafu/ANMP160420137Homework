package com.example.anmp160420137

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.anmp160420137.R
import com.example.anmp160420137.databinding.FragmentStudentDetailBinding
import com.example.anmp160420137.Student
import com.example.anmp160420137.DetailViewModel
import com.squareup.picasso.Picasso


class StudentDetailFragment : Fragment() {
    private lateinit var binding:FragmentStudentDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailViewModel.fetch()
        detailViewModel.studentLD.observe(viewLifecycleOwner, Observer { student ->
            updateUI(student)
        })
        //Part of Week7 Exercise
        val photoUrl = studentDetail.photoUrl
        Picasso.get().load(photoUrl).into(studentImageView)
    }
    private fun updateUI(student: Student) {
        binding.txtId.setText(student.id)
        binding.txtName.setText(student.name)
        binding.txtBod.setText(student.bod)
        binding.txtPhone.setText(student.phone)

    }
}