package com.example.app_kairos_projeto01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private var myList: List<Tarefa>,
    private val onItemCheckChanged: (Tarefa) -> Unit
) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTarefa: TextView = itemView.findViewById(R.id.textTarefa)
        val checkBoxTarefa: CheckBox = itemView.findViewById(R.id.checkBoxTarefa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tarefa_adapter, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tarefa = myList[position]

        holder.textTarefa.text = tarefa.nomeDaTarefa
        holder.checkBoxTarefa.isChecked = tarefa.isCompleted

        holder.checkBoxTarefa.setOnCheckedChangeListener { _, isChecked ->
            tarefa.isCompleted = isChecked
            onItemCheckChanged(tarefa)
        }
    }

    fun atualizarLista(novaLista: List<Tarefa>) {
        myList = novaLista
        notifyDataSetChanged()
    }
    override fun getItemCount() = myList.size
}
