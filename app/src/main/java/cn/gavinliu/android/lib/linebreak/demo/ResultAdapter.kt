package cn.gavinliu.android.lib.linebreak.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    companion object {
        const val TEXT_SIZE_MIN = 16f
    }

    var data: List<String> = emptyList()
    var textSize: Float = TEXT_SIZE_MIN

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (textSize < TEXT_SIZE_MIN) {
            textSize = TEXT_SIZE_MIN
        }

        holder.textView.textSize = textSize
        holder.textView.text = data[position]
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.text)
        }

    }

}