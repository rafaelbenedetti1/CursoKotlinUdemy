package com.Udemy.CursoKotlin.utils

import org.springframework.validation.BindingResult

object Utils {

    fun getMensagens(bindingResult: BindingResult): ArrayList<String> {
        val mensagens = arrayListOf<String>()

        bindingResult.fieldErrors.forEach {
            it.defaultMessage?.let { l -> mensagens.add(l) }
        }

        return mensagens
    }

}