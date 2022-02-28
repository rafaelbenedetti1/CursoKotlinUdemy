package com.Udemy.CursoKotlin.controller.response

import com.Udemy.CursoKotlin.enum.CustomerStatus
import javax.persistence.*

data class CustomerResponse (
        var id: Int? = null,
        var name: String,
        var email: String,
        var status: CustomerStatus
        )
