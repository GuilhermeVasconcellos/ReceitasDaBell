package com.example.receitasdabell

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//data class Receita(var resIdImagem: Int, var titulo: String, var tempoPreparo: String, var ingredientes: List<String>) {
@Parcelize
data class Receita(
    val resIdImagem: Int,
    val titulo: String,
    val tempoPreparo: String,
    val ingredientes: List<String>
    ) : Parcelable