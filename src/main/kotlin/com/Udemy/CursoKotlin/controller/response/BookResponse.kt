package com.Udemy.CursoKotlin.controller.response

import com.Udemy.CursoKotlin.enum.BookStatus
import com.Udemy.CursoKotlin.model.CustomerModel
import java.math.BigDecimal
import javax.persistence.*

data class BookResponse (
        var id: Int? = null,
        var name: String,
        var price: BigDecimal,
        var status: BookStatus? = null,
        var customer: CustomerModel? = null
        )


