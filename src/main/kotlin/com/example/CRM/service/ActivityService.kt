package com.example.CRM.service

import com.example.CRM.dto.ActivityDTO
import com.example.CRM.model.Activity
import com.example.CRM.model.Lead
import com.example.CRM.repository.ActivityRepository
import com.example.CRM.repository.LeadRepository
import org.springframework.stereotype.Service

@Service
class ActivityService(
    private val activityRepository: ActivityRepository,
    private val leadRepository: LeadRepository
) {

    fun getAllActivities(): List<ActivityDTO> =
        activityRepository.findAll().map { activity ->
            ActivityDTO(activity.id, activity.lead.id, activity.description, activity.date)
        }

    fun getActivityById(id: Long): ActivityDTO? =
        activityRepository.findById(id).map { activity ->
            ActivityDTO(activity.id, activity.lead.id, activity.description, activity.date)
        }.orElse(null)


    fun createActivity(leadId: Long, activityDTO: ActivityDTO): ActivityDTO {

        val lead: Lead = leadRepository.findById(leadId)
            .orElseThrow { IllegalArgumentException("Lead not found with id: $leadId") }


        val activity = Activity(
            lead = lead,
            description = activityDTO.description,
            date = activityDTO.date
        )
        val savedActivity = activityRepository.save(activity)
        return ActivityDTO(savedActivity.id, savedActivity.lead.id, savedActivity.description, savedActivity.date)
    }
}
