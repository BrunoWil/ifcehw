package com.bruno.huaweiquiz.ui.simulado

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bruno.huaweiquiz.R

// Adapte para lidar com os diferentes tipos de questões
class QuestionAdapter(private val questions: List<Question>) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvQuestion: TextView = view.findViewById(R.id.tvQuestion)
        val radioGroup: RadioGroup = view.findViewById(R.id.radioGroup)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questions[position]
        holder.tvQuestion.text = question.question

        // Configura opções de acordo com o tipo de questão
        holder.radioGroup.removeAllViews()

        when (question) {
            is MultipleChoiceQuestion -> {
                // Adiciona opções de múltipla escolha
                question.options.forEachIndexed { index, option ->
                    val radioButton = RadioButton(holder.radioGroup.context).apply {
                        text = option
                        id = index
                    }
                    holder.radioGroup.addView(radioButton)
                }
                // Lógica para capturar múltiplas escolhas (exemplo simplificado)
                holder.radioGroup.setOnCheckedChangeListener { _, checkedId ->
                    if (checkedId != -1) {
                        val selectedOption = question.options[checkedId]
                        // Capture a resposta selecionada (implemente a lógica necessária)
                    }
                }
            }

            is SingleChoiceQuestion -> {
                // Adiciona opções de escolha única
                question.options.forEachIndexed { index, option ->
                    val radioButton = RadioButton(holder.radioGroup.context).apply {
                        text = option
                        id = index
                    }
                    holder.radioGroup.addView(radioButton)
                }
                // Lógica para capturar escolha única
                holder.radioGroup.setOnCheckedChangeListener { _, checkedId ->
                    if (checkedId != -1) {
                        val selectedOption = question.options[checkedId]
                        // Capture a resposta selecionada (implemente a lógica necessária)
                    }
                }
            }

            is TrueFalseQuestion -> {
                // Adiciona opções Verdadeiro/Falso
                listOf("Verdadeiro", "Falso").forEachIndexed { index, option ->
                    val radioButton = RadioButton(holder.radioGroup.context).apply {
                        text = option
                        id = index
                    }
                    holder.radioGroup.addView(radioButton)
                }
                // Lógica para capturar Verdadeiro/Falso
                holder.radioGroup.setOnCheckedChangeListener { _, checkedId ->
                    val isTrue = checkedId == 0
                    // Capture a resposta (true ou false)
                }
            }
        }
    }

    override fun getItemCount(): Int = questions.size
}

