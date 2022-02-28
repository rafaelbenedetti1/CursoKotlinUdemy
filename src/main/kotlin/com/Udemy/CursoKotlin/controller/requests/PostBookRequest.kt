package com.Udemy.CursoKotlin.controller.requests

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequest (
    var name: String,
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customerId: Int
    )
