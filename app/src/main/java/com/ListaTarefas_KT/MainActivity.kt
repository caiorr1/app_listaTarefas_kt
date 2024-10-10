package com.ListaTarefas_KT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewTarefas: RecyclerView
    private lateinit var tarefaAdapter: TarefaAdapter
    private val listaTarefas = mutableListOf<Tarefa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar RecyclerView
        recyclerViewTarefas = findViewById(R.id.recyclerViewTarefas)
        tarefaAdapter = TarefaAdapter(listaTarefas)
        recyclerViewTarefas.adapter = tarefaAdapter
        recyclerViewTarefas.layoutManager = LinearLayoutManager(this)

        // Adicionar algumas tarefas de exemplo
        listaTarefas.add(Tarefa("Comprar leite"))
        listaTarefas.add(Tarefa("Estudar Kotlin"))
        listaTarefas.add(Tarefa("Fazer exercícios"))
        tarefaAdapter.notifyDataSetChanged()
    }
}