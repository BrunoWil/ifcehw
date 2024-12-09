package com.bruno.huaweiquiz.ui.historico
import ListHistorico
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bruno.huaweiquiz.databinding.FragmentHistoricoBinding

class HistoricoFragment : Fragment() {

    private var _binding: FragmentHistoricoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val historicoBindingViewModel =
            ViewModelProvider(this).get(HistoricoBindingViewModel::class.java)

        _binding = FragmentHistoricoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configurar o RecyclerView
        val recyclerView = binding.recyclerViewHistorico

        // Dados para o RecyclerView
        val items = listOf(
            HistoricoItem("Simulado 1", "Acertos 0%", "Erros 0%", "Brancos 0%"),
            HistoricoItem("Simulado 2", "Acertos 0%", "Erros 0%", "Brancos 0%"),
            HistoricoItem("Simulado 3", "Acertos 0%", "Erros 0%", "Brancos 0%"),
            HistoricoItem("Simulado 4", "Acertos 0%", "Erros 0%", "Brancos 0%"),
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListHistorico(items)


//        val textView: TextView = binding.textHistorico
//        historicoBindingViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}