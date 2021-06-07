package com.consultantAndClient.accounts.repository

import com.consultantAndClient.accounts.CreateFirstData
import com.consultantAndClient.accounts.model.Company
import com.consultantAndClient.accounts.model.Employee
import org.springframework.stereotype.Repository

@Repository
class CompanyRepository : CrudFunction<Company> {

    private val companies = CreateFirstData().companies

    override fun create(company: Company): Company {
        var id = companies.maxOf { c -> c.id }
        companies.add(company)
        return company
    }

    override fun delete(t: Company) {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableSet<Company>? {
        return companies
    }

    override fun findById(id: Long): Company? {
        return companies.find { c -> c.id == id }
    }

    override fun getId(): Long {
        return companies.maxOf { c -> c.id }
    }

    fun getEmployeesInCompany(id: Long): MutableSet<Employee>? {
        val company = findById(id)
        return company?.employees
    }
}