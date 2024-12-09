package com.bruno.huaweiquiz.ui.home

import MyAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bruno.huaweiquiz.R
import com.bruno.huaweiquiz.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        // Inflate o layout usando ViewBinding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val botao = binding.iniciarSimulado

        botao.setOnClickListener {
            findNavController().navigate(R.id.navigation_simulado)
        }



        // Configurar o RecyclerView
        val recyclerView = binding.recyclerView

        // Dados para o RecyclerView
        val items = listOf(
            "Assunto 1" to "0%",
            "Assunto 2" to "0%",
            "Assunto 3" to "0%",
            "Assunto 4" to "0%",
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MyAdapter(items)



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

