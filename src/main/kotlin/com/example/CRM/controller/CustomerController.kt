package com.example.CRM.controller

import com.example.CRM.dto.CustomerDTO
import com.example.CRM.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getAllCustomers(): ResponseEntity<List<CustomerDTO>> {
        val customers = customerService.getAllCustomers()
        return ResponseEntity.ok(customers)
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Long): ResponseEntity<CustomerDTO?> {
        val customer = customerService.getCustomerById(id)
        return ResponseEntity.ok(customer)
    }

    @PostMapping
    fun createCustomer(@RequestBody customerDTO: CustomerDTO): ResponseEntity<CustomerDTO> {
        val createdCustomer = customerService.createCustomer(customerDTO)
        return ResponseEntity.ok(createdCustomer)
    }

    @PutMapping("/{id}")
    fun updateCustomer(
        @PathVariable id: Long,
        @RequestBody customerDTO: CustomerDTO
    ): ResponseEntity<CustomerDTO?> {
        val updatedCustomer = customerService.updateCustomer(id, customerDTO)
        return ResponseEntity.ok(updatedCustomer)
    }
}
