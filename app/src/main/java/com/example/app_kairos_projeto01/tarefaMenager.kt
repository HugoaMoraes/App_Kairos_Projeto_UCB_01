package com.example.app_kairos_projeto01

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken

class TarefaManager(private val context: Context) {
    // ... outros métodos ...

    fun lerTarefasDoSharedPreferences(): List<Tarefa> {
        // Usando a chave definida no arquivo de recursos
        val sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val gson = Gson()
        val tarefasJson = sharedPref.getString("tarefas", null)
        val type = object : TypeToken<List<Tarefa>>() {}.type

        return try {
            gson.fromJson(tarefasJson, type) ?: emptyList()
        } catch (e: JsonSyntaxException) {
            e.printStackTrace()
            emptyList()
        }
    }

    fun salvarTarefa(tarefaAtualizada: Tarefa, afterSave: () -> Unit) {
        val sharedPrefName = context.getString(R.string.preference_file_key)

        val sharedPref = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val gson = Gson()

        // Obter a lista atual de tarefas
        val tarefasJson = sharedPref.getString("tarefas", null)
        val type = object : TypeToken<List<Tarefa>>() {}.type
        val tarefas: MutableList<Tarefa> = gson.fromJson(tarefasJson, type) ?: mutableListOf()

        // Atualizar a tarefa na lista
        val index = tarefas.indexOfFirst { it.nomeDaTarefa == tarefaAtualizada.nomeDaTarefa }
        if (index != -1) {
            tarefas[index] = tarefaAtualizada
        }

        // Salvar a lista atualizada no SharedPreferences
        editor.putString("tarefas", gson.toJson(tarefas))
        editor.apply()

        afterSave()
    }

}