package com.Udemy.CursoKotlin.model

import com.Udemy.CursoKotlin.enum.CustomerStatus
import javax.persistence.*

@Entity(name="customer")
data class CustomerModel (

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        var id: Int? = null,
        @Column
        var name: String,
        @Column
        var email: String,
        @Column
        @Enumerated(EnumType.STRING)
        var status: CustomerStatus
        )
