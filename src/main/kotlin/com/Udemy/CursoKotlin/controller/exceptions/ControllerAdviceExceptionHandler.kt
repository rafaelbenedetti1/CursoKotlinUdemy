package com.Udemy.CursoKotlin.controller.exceptions

import com.Udemy.CursoKotlin.controller.response.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdviceExceptionHandler {
    @ExceptionHandler(
        Exception::class
    )
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ApiResponse<String>> {
        ex.printStackTrace()
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse(status = HttpStatus.INTERNAL_SERVER_ERROR, messages = arrayListOf("Erro Interno de Servidor")))
    }
}