package com.Udemy.CursoKotlin.controller.requests

import java.math.BigDecimal

data class PutBookRequest (
    var name: String?,
    var price: BigDecimal?
    )
