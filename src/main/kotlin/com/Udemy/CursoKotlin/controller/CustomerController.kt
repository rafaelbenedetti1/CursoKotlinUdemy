package com.Udemy.CursoKotlin.controller

import com.Udemy.CursoKotlin.controller.requests.PostCustomerRequest
import com.Udemy.CursoKotlin.controller.requests.PutCustomerRequest
import com.Udemy.CursoKotlin.controller.response.ApiResponse
import com.Udemy.CursoKotlin.controller.response.CustomerResponse
import com.Udemy.CursoKotlin.extension.toCustomerModel
import com.Udemy.CursoKotlin.extension.toResponse
import com.Udemy.CursoKotlin.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(
    private val customerService: CustomerService
) {

    /*Get por url passando nome como parametro, se vier preenchido o url, entra na lógica verificando
    se algum nome que está na base contem o que foi enviado, se não só ignora
    exemplo de get: customers/?name=rafa*/
    @GetMapping()
    fun getAll(@RequestParam name: String?): ApiResponse<List<CustomerResponse>> {
        val customer = customerService.getAll(name).map { it.toResponse() }
        return ApiResponse(status = HttpStatus.OK, data = customer)
    }

    /*Post para enviar um novo registro gerando um id sequencial,
    se não tiver nenhum registro, id recebe 1, se não incrementa mais um*/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        customerService.create(customer.toCustomerModel())
    }

    /* Recebendo variavel na url usando @PathVariable
     percorrendo a lista de customers comparando os ids, se tiver um registro
     igual ao que for passado na url ele retorna esse cara*/
    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
        return customerService.findById(id).toResponse()
    }

    /* Put feito para atualizar um registro*/
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        val customerSaved = customerService.findById(id)
        customerService.update(customer.toCustomerModel(customerSaved))
    }

    // deleta um registro
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }
}
