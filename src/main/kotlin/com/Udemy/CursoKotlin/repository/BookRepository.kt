package com.Udemy.CursoKotlin.repository

import com.Udemy.CursoKotlin.enum.BookStatus
import com.Udemy.CursoKotlin.model.BookModel
import com.Udemy.CursoKotlin.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository : JpaRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>

}