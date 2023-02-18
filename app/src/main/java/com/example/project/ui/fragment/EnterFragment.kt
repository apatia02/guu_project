package com.example.project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project.R
import com.example.project.databinding.FragmentEnterBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EnterFragment : Fragment() {
    private var _binding: FragmentEnterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}