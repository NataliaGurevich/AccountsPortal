package com.consultantAndClient.accounts.controller

import com.consultantAndClient.accounts.form.CompanyForm
import com.consultantAndClient.accounts.model.Company
import com.consultantAndClient.accounts.model.StatusOfCompany
import com.consultantAndClient.accounts.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class CompanyController @Autowired constructor(
    var companyService: CompanyService
) {
    var company: Company? = null

    @GetMapping("/newCompany")
    fun addCompany(model: Model): String {
        model.addAttribute("companyForm", CompanyForm())
        return "new_company"
    }

    @PostMapping("/consultant")
    fun doAddCompany(
        @RequestParam("name", defaultValue = "") name: String,
        @RequestParam("steuerNummer", defaultValue = "") steuerNummer: String,
        model: Model
    ): String {
        var id = companyService.getId()
        val newCompany = Company(++id, name, steuerNummer, StatusOfCompany.ON_DEMAND, mutableSetOf())
        companyService.addCompany(newCompany)
        model.addAttribute("company", newCompany)

        val firstName = model.getAttribute("firstName")
        val lastName = model.getAttribute("lastName")
        model.addAttribute("name", "$firstName $lastName")

        return "redirect:/consultant"
    }

    @GetMapping("/company/{id}")
    fun companyPortal(@PathVariable("id") id: Long, model: Model): String {
        company = companyService.getCompanyById(id)
        model.addAttribute("company", company)
        model.addAttribute("employees", companyService.getAllEmployees(id))
        return "company"
    }

    @GetMapping("employee/{id}")
    fun employee(@PathVariable("id") id: Long, model: Model): String {
        val employees = company?.employees
        model.addAttribute("employee", employees?.find { it.id == id })
        return "employee"
    }
}