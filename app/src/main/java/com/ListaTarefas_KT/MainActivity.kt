package com.ListaTarefas_KT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
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

        // Configurar botão para adicionar nova tarefa
        val botaoAdicionar = findViewById<Button>(R.id.botaoAdicionar)
        botaoAdicionar.setOnClickListener {
            mostrarDialogAdicionarTarefa()
        }
    }

    // Função para mostrar o AlertDialog de nova tarefa
    private fun mostrarDialogAdicionarTarefa() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Nova Tarefa")

        // Input de texto para a nova tarefa
        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        // Configurar os botões do diálogo
        builder.setPositiveButton("Adicionar") { _, _ ->
            val tarefaNome = input.text.toString()
            if (tarefaNome.isNotEmpty()) {
                listaTarefas.add(Tarefa(tarefaNome))
                tarefaAdapter.notifyDataSetChanged()
            }
        }
        builder.setNegativeButton("Cancelar") { dialog, _ -> dialog.cancel() }

        builder.show()
    }
}
