package com.consultantAndClient.accounts.model

data class Company(
    val id: Long,
    var name: String,
    var steuerNummer: String,
    var status: StatusOfCompany,
    var employees: MutableSet<Employee>
)