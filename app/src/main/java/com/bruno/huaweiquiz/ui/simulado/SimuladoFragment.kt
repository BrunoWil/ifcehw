package com.bruno.huaweiquiz.ui.simulado

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bruno.huaweiquiz.databinding.FragmentSimuladoBinding

class SimuladoFragment : Fragment() {

    private var _binding: FragmentSimuladoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val simuladoViewModel =
            ViewModelProvider(this).get(SimuladoViewModel::class.java)

        _binding = FragmentSimuladoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configurar o RecyclerView
        val recyclerView: RecyclerView = binding.questionsrecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Dados simulados de exemplo
        val questions: List<Question> = listOf(
            MultipleChoiceQuestion(
                question = "Quais dessas linguagens são consideradas de alto nível?",
                options = listOf("Assembly", "C", "Python", "Java", "Swift", "Machine Code"),
                correctAnswers = setOf(2, 3, 4)
            ),
            SingleChoiceQuestion(
                question = "Qual a capital do Brasil?",
                options = listOf("Rio de Janeiro", "São Paulo", "Brasília", "Salvador", "Belo Horizonte", "Curitiba"),
                correctAnswer = 2
            ),
            TrueFalseQuestion(
                question = "A Terra é plana?",
                correctAnswer = false
            )
        )

        // Configurar o Adapter
        val adapter = QuestionAdapter(questions)
        recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
