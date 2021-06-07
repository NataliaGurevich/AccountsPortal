package com.consultantAndClient.accounts.model

data class Consultant(
    val id: Long,
    var lastName: String,
    var firstName: String,
    var email: String,
    var password: String,
    var role: RoleConsultant
) {
}