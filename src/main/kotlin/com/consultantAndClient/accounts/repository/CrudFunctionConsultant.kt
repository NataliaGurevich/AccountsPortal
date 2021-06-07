package com.consultantAndClient.accounts.repository

interface CrudFunctionConsultant<T> {

    fun findByEmail(email: String): T?
}