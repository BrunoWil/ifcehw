import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bruno.huaweiquiz.R
import com.bruno.huaweiquiz.ui.historico.HistoricoItem

class ListHistorico(private val items: List<HistoricoItem>) :
    RecyclerView.Adapter<ListHistorico.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewSimuladoName: TextView = itemView.findViewById(R.id.itemSimuladoName)
        val textViewHistoricoAcertos: TextView = itemView.findViewById(R.id.itemHistoricoAcertos)
        val textViewHistoricoErros: TextView = itemView.findViewById(R.id.itemHistoricoErros)
        val textViewHistoricoBrancos: TextView = itemView.findViewById(R.id.itemHistoricoBrancos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itens_layout_historico, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textViewSimuladoName.text = item.simuladoName
        holder.textViewHistoricoAcertos.text = item.acertos
        holder.textViewHistoricoErros.text = item.erros
        holder.textViewHistoricoBrancos.text = item.brancos
    }


    override fun getItemCount(): Int = items.size
}
