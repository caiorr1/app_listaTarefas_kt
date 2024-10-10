package com.ListaTarefas_KT

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaAdapter(private val listaTarefas: MutableList<Tarefa>) :
    RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tarefaNome: TextView = itemView.findViewById(R.id.tarefaNome)
        val botaoExcluir: Button = itemView.findViewById(R.id.botaoExcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listaTarefas[position]
        holder.tarefaNome.text = tarefa.nome

        holder.botaoExcluir.setOnClickListener {
            listaTarefas.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }
}