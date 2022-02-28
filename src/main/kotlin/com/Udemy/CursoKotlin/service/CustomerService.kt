package com.Udemy.CursoKotlin.service

import com.Udemy.CursoKotlin.enum.CustomerStatus
import com.Udemy.CursoKotlin.model.CustomerModel
import com.Udemy.CursoKotlin.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository, val bookService: BookService) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(name)
        }
        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {

        customerRepository.save(customer)
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).get()
    }

    fun update(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }

        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)
        customer.status = CustomerStatus.INATIVO
        customerRepository.save(customer)
    }

}