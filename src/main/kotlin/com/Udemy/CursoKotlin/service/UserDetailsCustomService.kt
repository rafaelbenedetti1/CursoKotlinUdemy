package com.Udemy.CursoKotlin.service

import com.Udemy.CursoKotlin.repository.CustomerRepository
import com.Udemy.CursoKotlin.security.UserCustomDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsCustomService(
    private val customerRepository: CustomerRepository
): UserDetailsService {
    override fun loadUserByUsername(id: String): UserDetails {
        val customer = customerRepository.findById(id.toInt()).orElseThrow()
        return UserCustomDetails(customer)
    }
}