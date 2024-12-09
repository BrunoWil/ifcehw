package com.bruno.huaweiquiz.ui.processo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bruno.huaweiquiz.databinding.FragmentProcessoBinding

class ProcessoFragment : Fragment() {

    private var _binding: FragmentProcessoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val loginViewModel =
            ViewModelProvider(this).get(ProcessoViewModel::class.java)

        _binding = FragmentProcessoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textProcesso
        loginViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}