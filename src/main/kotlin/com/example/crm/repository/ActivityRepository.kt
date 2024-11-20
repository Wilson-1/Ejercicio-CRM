package com.example.crm.repository

import com.example.crm.model.Activity
import com.example.crm.model.Lead
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivityRepository : JpaRepository<Activity, Long> {

    fun findAllByLead(lead: Lead): List<Activity>
}
