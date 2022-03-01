package com.Udemy.CursoKotlin.extension

import com.Udemy.CursoKotlin.controller.requests.PostBookRequest
import com.Udemy.CursoKotlin.controller.requests.PostCustomerRequest
import com.Udemy.CursoKotlin.controller.requests.PutBookRequest
import com.Udemy.CursoKotlin.controller.requests.PutCustomerRequest
import com.Udemy.CursoKotlin.controller.response.BookResponse
import com.Udemy.CursoKotlin.controller.response.CustomerResponse
import com.Udemy.CursoKotlin.controller.response.PageResponse
import com.Udemy.CursoKotlin.enum.BookStatus
import com.Udemy.CursoKotlin.enum.CustomerStatus
import com.Udemy.CursoKotlin.model.BookModel
import com.Udemy.CursoKotlin.model.CustomerModel
import org.springframework.data.domain.Page

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ATIVO, password = this.password)
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(id= previousValue.id ,name = this.name, email = this.email, status = previousValue.status, password = previousValue.password)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status
    )
}

fun <T> Page<T>.toPageResponse(): PageResponse<T> {
    return PageResponse(this.content, this.number, this.totalElements, this.totalPages)
}