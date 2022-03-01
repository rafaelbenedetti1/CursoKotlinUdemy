package com.Udemy.CursoKotlin.model

import com.Udemy.CursoKotlin.enum.CustomerStatus
import com.Udemy.CursoKotlin.enum.Role
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
        var status: CustomerStatus,
        @Column
        val password: String,

        @Column(name = "roles")
        @Enumerated(EnumType.STRING)
        @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
        @CollectionTable(name = "customer_roles", joinColumns = [JoinColumn(name="customer_id")])
        var roles: Set<Role> = setOf()
        )
