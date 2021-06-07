package com.consultantAndClient.accounts.form

import com.consultantAndClient.accounts.model.Company

class ConsultantPortalForm {
    var firstName: String? = null
    var lastName: String? = null
    var companies = mutableListOf<Company>()
}