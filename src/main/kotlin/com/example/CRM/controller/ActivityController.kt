package com.example.CRM.controller

import com.example.CRM.dto.ActivityDTO
import com.example.CRM.service.ActivityService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/activities")
class ActivityController(private val activityService: ActivityService) {

    @PostMapping("/leads/{leadId}/activities")
    fun createActivity(
        @PathVariable leadId: Long,
        @RequestBody activityDTO: ActivityDTO
    ): ResponseEntity<ActivityDTO> {
        val createdActivity = activityService.createActivity(leadId, activityDTO)
        return ResponseEntity.ok(createdActivity)
    }

    @GetMapping
    fun getAllActivities(): ResponseEntity<List<ActivityDTO>> {
        val activities = activityService.getAllActivities()
        return ResponseEntity.ok(activities)
    }

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: Long): ResponseEntity<ActivityDTO?> {
        val activity = activityService.getActivityById(id)
        return ResponseEntity.ok(activity)
    }
}
