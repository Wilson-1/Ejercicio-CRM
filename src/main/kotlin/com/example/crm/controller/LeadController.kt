package com.example.crm.controller

import com.example.crm.dto.LeadDTO
import com.example.crm.service.LeadService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/leads")
class LeadController(private val leadService: LeadService) {

    @GetMapping
    fun getAllLeads(): ResponseEntity<List<LeadDTO>> {
        val leads = leadService.getAllLeads()
        return ResponseEntity.ok(leads)
    }

    @GetMapping("/{id}")
    fun getLeadById(@PathVariable id: Long): ResponseEntity<LeadDTO> {
        val lead = leadService.getLeadById(id)
        return ResponseEntity.ok(lead)
    }

    @PostMapping
    fun createLead(@RequestBody leadDTO: LeadDTO): ResponseEntity<LeadDTO> {
        val createdLead = leadService.createLead(leadDTO)
        return ResponseEntity.ok(createdLead)
    }

    @PutMapping("/{id}")
    fun updateLead(
        @PathVariable id: Long,
        @RequestBody leadDTO: LeadDTO
    ): ResponseEntity<LeadDTO> {
        val updatedLead = leadService.updateLead(id, leadDTO)
        return ResponseEntity.ok(updatedLead)
    }

    @DeleteMapping("/{id}")
    fun deleteLead(@PathVariable id: Long): ResponseEntity<Void> {
        leadService.deleteLead(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}/set-status")
    fun updateLeadStatus(
        @PathVariable id: Long,
        @RequestBody statusUpdate: Map<String, String>
    ): ResponseEntity<LeadDTO> {
        val status = statusUpdate["status"] ?: throw IllegalArgumentException("Status is required")
        val updatedLead = leadService.updateStatus(id, status)
        return ResponseEntity.ok(updatedLead)
    }
}
