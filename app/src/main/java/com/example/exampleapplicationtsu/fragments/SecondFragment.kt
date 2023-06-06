package com.example.exampleapplicationtsu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exampleapplicationtsu.R
import com.example.exampleapplicationtsu.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {
    private lateinit var _binding : FragmentSecondBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val args = SecondFragmentArgs.fromBundle(requireArguments())
            textView11.text = args.text1
            textView12.text = args.text2
            textView13.text = args.text3
        }
    }
}