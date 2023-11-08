package com.example.app_kairos_projeto01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adpter(
    private  val myList: List<String>,
    private val markSelected: MutableList<Boolean>,
    private val onItemCheckChanged: (String) -> Unit // Adiciona um lambda como parâmetro
)
    : RecyclerView.Adapter<Adpter.MyViewHolder>() {
    class  MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val textTarefa: TextView = itemView.findViewById(R.id.textTarefa)
        val checkBoxTarefa: CheckBox = itemView.findViewById(R.id.checkBoxTarefa)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tarefa_adapter, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tarefa = myList[position]
        val isMarked = markSelected[position]

        holder.textTarefa.text = tarefa
        holder.checkBoxTarefa.isChecked = isMarked

        holder.checkBoxTarefa.setOnCheckedChangeListener { _, isChecked ->
            markSelected[position] = isChecked
            onItemCheckChanged(tarefa)
        }
    }

    override fun getItemCount() = myList.size
}