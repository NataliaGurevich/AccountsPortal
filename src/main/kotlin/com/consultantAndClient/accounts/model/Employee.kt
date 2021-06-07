package com.consultantAndClient.accounts.model

data class Employee(
    val id: Long,
    var firstName: String,
    var lastName: String,
    var password: String,
    var role: RoleUser
)