package com.example.CRM.dto

import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ActivityDTO(
    val id: Long? = null, // Opcional al crear actividades.
    @field:NotNull(message = "Lead ID is required")
    val leadId: Long,
    @field:NotBlank(message = "Description cannot be blank")
    val description: String,
    @field:NotNull(message = "Date is required")
    val date: LocalDateTime
)
