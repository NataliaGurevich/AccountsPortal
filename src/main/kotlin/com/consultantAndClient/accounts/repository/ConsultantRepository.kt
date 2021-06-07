package com.consultantAndClient.accounts.repository

import com.consultantAndClient.accounts.CreateFirstData
import com.consultantAndClient.accounts.model.Consultant
import org.springframework.stereotype.Repository

@Repository
class ConsultantRepository : CrudFunction<Consultant>, CrudFunctionConsultant<Consultant> {

    private val consultants = CreateFirstData().consultants

    override fun create(consultant: Consultant): Consultant {
        consultants.add(consultant)
        return consultant
    }

    override fun delete(t: Consultant) {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableSet<Consultant>? {
        return consultants
    }

    override fun findById(id: Long): Consultant? {
        return consultants.find { c -> c.id == id }
    }

    override fun findByEmail(email: String): Consultant? {
        return consultants.find { c ->
            c.email == email
        }
    }

    override fun getId(): Long {
        return consultants.maxOf { c -> c.id }
    }
}