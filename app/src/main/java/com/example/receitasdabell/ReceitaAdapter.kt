package com.example.receitasdabell

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.receitasdabell.databinding.ItemReceitaBinding

class ReceitaAdapter(
    private val onClick: (Receita) -> Unit
) : RecyclerView.Adapter<ReceitaAdapter.ReceitaViewHolder>() {

    private val listaReceitas = DadosReceita.recuperarReceitas()

    inner class ReceitaViewHolder(itemBinding: ItemReceitaBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        private val binding: ItemReceitaBinding

        init {
            binding = itemBinding
        }

        fun bind(receita: Receita, onClick: (Receita) -> Unit) {

            itemView.setOnClickListener {
                onClick(receita)
            }

            binding.textTitulo.text = receita.titulo
            binding.textTempo.text = receita.tempoPreparo
            binding.imageReceita.setImageDrawable(
                ContextCompat.getDrawable(itemView.context, receita.resIdImagem)
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitaViewHolder {
        /*val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_receita, parent, false)*/

        val itemReceitaBinding = ItemReceitaBinding.inflate(
            LayoutInflater
                .from(parent.context)
        )

        Log.i("lista", "onCreateViewHolder - ${listaReceitas.toString()}")

        return ReceitaViewHolder(itemReceitaBinding)
    }

    override fun onBindViewHolder(holder: ReceitaViewHolder, position: Int) {
        Log.i("lista", "onBindViewHolder - ${listaReceitas[position]}")
        val receita = listaReceitas[position]
        holder.bind(receita, onClick)
    }

    override fun getItemCount(): Int {
        Log.i("lista", "getItemCount - ${listaReceitas.size}")
        return listaReceitas.size
    }
}