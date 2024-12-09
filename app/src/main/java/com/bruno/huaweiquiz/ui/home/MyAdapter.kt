import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bruno.huaweiquiz.R

class MyAdapter(private val items: List<Pair<String, String>>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.findViewById(R.id.itemTextView)
        val textView2: TextView = itemView.findViewById(R.id.itemTextView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itens_layout_acertos_assuntos, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (text1, text2) = items[position]
        holder.textView1.text = text1
        holder.textView2.text = text2
    }

    override fun getItemCount(): Int = items.size
}
