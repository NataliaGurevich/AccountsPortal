package com.consultantAndClient.accounts.service

import com.consultantAndClient.accounts.model.Consultant
import com.consultantAndClient.accounts.repository.ConsultantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ConsultantService @Autowired constructor(
val repository: ConsultantRepository)
{
    fun login(email: String?, password: String?): Boolean {
        val consultant = email?.let { getConsultant(it, password) }
        return consultant != null
    }

    fun getConsultant(email: String, password: String?): Consultant? {
        val consultant = repository.findByEmail(email)
        return if (consultant != null && consultant.password == password) consultant else null
    }
}