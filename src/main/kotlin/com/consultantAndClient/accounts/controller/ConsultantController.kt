package com.consultantAndClient.accounts.controller

import com.consultantAndClient.accounts.form.LoginConsultantForm
import com.consultantAndClient.accounts.model.Consultant
import com.consultantAndClient.accounts.service.CompanyService
import com.consultantAndClient.accounts.service.ConsultantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ConsultantController @Autowired constructor(
    var consultantService: ConsultantService,
    var companyService: CompanyService
) {
    var consultant: Consultant? = null

    @GetMapping("/login")
    fun loginConsultant(model: Model): String {
        val loginConsultant = LoginConsultantForm()
        model.addAttribute("loginConsultantForm", loginConsultant)
        return "login_consultant"
    }

    @PostMapping("/consultantPortal")
    fun doLoginConsultant(@RequestParam("email", defaultValue = "")email:String,
                          @RequestParam("password", defaultValue = "")password:String,
                          model: Model): String {
        consultant = consultantService.getConsultant(email, password)
        model.addAttribute("consultant", consultant)

        return if (consultantService.login(email, password))
            "redirect:/consultant" else "tryAgain"
    }

    @GetMapping("/consultant")
    fun consultantPortal(model: Model): String {
        model.addAttribute("companies", companyService.getAllCompanies())
        model.addAttribute("consultant", consultant)

        return "consultant_portal"
    }

    @GetMapping("/consultant/{id}")
    fun consultantPortal(@PathVariable("id") id: Long, model: Model): String {
        model.addAttribute("consultant", consultant)
        return "consultant"
    }
}