package com.example.project.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.project.data.IncidentDto
import com.example.project.databinding.FragmentQuestionBinding
import com.example.project.ui.viewmodel.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: QuestionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            send.setOnClickListener {
                viewModel.newIncident(
                    IncidentDto(
                        0,
                        name.text.toString(),
                        corpus.text.toString(),
                        room.text.toString(),
                        category.text.toString(),
                        description.text.toString(),
                        1
                    )
                )
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}