package com.example.project.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.project.R
import com.example.project.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            questions.setOnClickListener { findNavController().navigate(R.id.action_MainFragment_to_QuestionFragment) }
            list.setOnClickListener { findNavController().navigate(R.id.action_MainFragment_to_ListIncidentsFragment) }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}