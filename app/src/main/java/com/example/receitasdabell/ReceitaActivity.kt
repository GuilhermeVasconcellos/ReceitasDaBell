package com.example.receitasdabell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.receitasdabell.databinding.ActivityReceitaBinding

class ReceitaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReceitaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVoltar.setOnClickListener {
            finish()
        }

        val bundle = intent.extras

        val receita = bundle?.getParcelable<Receita>("receita") as Receita

        if(receita != null){
            binding.imageReceitaSelecionada.setImageDrawable(ContextCompat.getDrawable(this, receita.resIdImagem))
            binding.textTituloReceita.text = receita.titulo
            binding.textTempoPreparo.text = receita.tempoPreparo

            var ingredientes = ""
            receita.ingredientes.forEach {
                ingredientes += "- $it \n"
            }
            binding.textPreparo.text = ingredientes
        }

    }
}