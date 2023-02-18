package com.example.project.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.project.data.IncidentDto
import com.example.project.databinding.FragmentDetailFragmentBinding
import com.example.project.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragmentFragment : Fragment() {
    private var _binding: FragmentDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            var incident: IncidentDto? = null
            lifecycleScope.launchWhenStarted {
                viewModel.list.collect {
                    if (it.isNotEmpty()) {
                        it.forEach { it1 ->
                            if (it1.id == args.id)
                                incident = it1
                        }
                        name.text = incident?.name
                        corpus.text = incident?.corpus
                        room.text = incident?.room
                        category.text = incident?.category
                        description.text = incident?.description
                    }
                }
            }
            doIncident.setOnClickListener {
                viewModel.doIncident(args.id)
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}