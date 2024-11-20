package com.example.crm.service

import com.example.crm.dto.LeadDTO
import com.example.crm.model.Lead
import com.example.crm.repository.LeadRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LeadService {

    @Autowired
    private lateinit var leadRepository: LeadRepository


    fun getAllLeads(): List<LeadDTO> {
        val leads = leadRepository.findAll()
        return leads.map { lead -> LeadDTO(lead.id, lead.customerId, lead.source, lead.status) }
    }


    fun getLeadById(id: Long): LeadDTO {
        val lead = leadRepository.findById(id).orElseThrow {
            throw RuntimeException("Lead not found with id: $id")
        }
        return LeadDTO(lead.id, lead.customerId, lead.source, lead.status)
    }


    fun createLead(leadDTO: LeadDTO): LeadDTO {
        val lead = Lead(
            customerId = leadDTO.customerId,
            source = leadDTO.source,
            status = leadDTO.status,
            name = ""
        )
        val savedLead = leadRepository.save(lead)
        return LeadDTO(savedLead.id, savedLead.customerId, savedLead.source, savedLead.status)
    }


    fun updateLead(id: Long, leadDTO: LeadDTO): LeadDTO {
        val existingLead = leadRepository.findById(id).orElseThrow {
            throw RuntimeException("Lead not found with id: $id")
        }

        existingLead.customerId = leadDTO.customerId
        existingLead.source = leadDTO.source
        existingLead.status = leadDTO.status

        val savedLead = leadRepository.save(existingLead)
        return LeadDTO(savedLead.id, savedLead.customerId, savedLead.source, savedLead.status)
    }


    fun deleteLead(id: Long) {
        if (!leadRepository.existsById(id)) {
            throw RuntimeException("Lead not found with id: $id")
        }
        leadRepository.deleteById(id)
    }


    fun updateStatus(id: Long, status: String): LeadDTO {
        val existingLead = leadRepository.findById(id).orElseThrow {
            throw RuntimeException("Lead not found with id: $id")
        }

        existingLead.status = status
        val updatedLead = leadRepository.save(existingLead)

        return LeadDTO(updatedLead.id, updatedLead.customerId, updatedLead.source, updatedLead.status)
    }
}
