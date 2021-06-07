package com.consultantAndClient.accounts.service

import com.consultantAndClient.accounts.model.Company
import com.consultantAndClient.accounts.model.Employee
import com.consultantAndClient.accounts.repository.CompanyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CompanyService @Autowired constructor(
val repository: CompanyRepository
)
{
    fun getAllCompanies(): MutableSet<Company>? {
        return repository.findAll()
    }

    fun getId(): Long {
        return repository.getId()
    }

    fun addCompany(company: Company) {
        repository.create(company)
    }

    fun getCompanyById(id: Long): Company? {
        return repository.findById(id)
    }

    fun getAllEmployees(id: Long): MutableSet<Employee>? {
        return repository.getEmployeesInCompany(id)
    }
}