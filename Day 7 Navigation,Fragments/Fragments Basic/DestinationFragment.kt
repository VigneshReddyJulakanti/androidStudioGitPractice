package com.example.fragmentpractice2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentpractice2.databinding.FragmentDestinationBinding
import com.example.fragmentpractice2.databinding.FragmentHomeBinding


class DestinationFragment : Fragment() {
    private lateinit var binding: FragmentDestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDestinationBinding.inflate(inflater,container,false)
        val input=requireArguments().getString("name_txt")
        binding.tvName.text=input
        // Inflate the layout for this fragment
        return binding.root
    }

}