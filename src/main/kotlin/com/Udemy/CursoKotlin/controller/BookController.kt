package com.Udemy.CursoKotlin.controller

import com.Udemy.CursoKotlin.controller.requests.PostBookRequest
import com.Udemy.CursoKotlin.controller.requests.PutBookRequest
import com.Udemy.CursoKotlin.controller.response.BookResponse
import com.Udemy.CursoKotlin.extension.toBookModel
import com.Udemy.CursoKotlin.extension.toResponse
import com.Udemy.CursoKotlin.service.BookService
import com.Udemy.CursoKotlin.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController (val customerService: CustomerService, val bookService: BookService){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
       val customer = customerService.findById(request.customerId)
       bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.findAll(pageable).map { it.toResponse() }
    }

    @GetMapping("active")
    fun findActives(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.findAllActives(pageable).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookResponse {
        return bookService.findById(id).toResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        return bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        var bookSaved = bookService.findById(id)
        return bookService.update(book.toBookModel(bookSaved))
    }
}