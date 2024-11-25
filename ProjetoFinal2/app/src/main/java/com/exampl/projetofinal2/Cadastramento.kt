package com.exampl.projetofinal2


class Cadastramento (val nome:String,val idade:String, val email:String){
    override fun toString(): String {
        return "$nome, $idade anos de idade; E-mail:$email"
    }
}
