package com.example.receitasdabell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.receitasdabell.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            rvReceitas.adapter = ReceitaAdapter{

                val intent = Intent(applicationContext, ReceitaActivity::class.java)
                intent.putExtra("receita", it)
                startActivity(intent)
            }

            rvReceitas.layoutManager = LinearLayoutManager(applicationContext)

            rvReceitas.addItemDecoration(
                DividerItemDecoration(applicationContext, LinearLayout.VERTICAL)
            )
        }

    }
}