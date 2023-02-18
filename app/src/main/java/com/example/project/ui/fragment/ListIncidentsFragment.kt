package com.example.project.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.project.databinding.FragmentListIncidentsBinding
import com.example.project.ui.adapter.IncidentAdapter
import com.example.project.ui.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListIncidentsFragment : Fragment() {
    private var _binding: FragmentListIncidentsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListIncidentsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val adapter = IncidentAdapter { click(it) }
            list.adapter = adapter
            lifecycleScope.launchWhenStarted {
                viewModel.list.collect {
                    adapter.submitList(it)
                    adapter.notifyItemRangeChanged(0,it.size)
                }
            }
        }
    }

    private fun click(id: Int) {
        findNavController().navigate(
            ListIncidentsFragmentDirections.actionListIncidentsFragmentToDetailFragmentFragment(
                id
            )
        )
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}