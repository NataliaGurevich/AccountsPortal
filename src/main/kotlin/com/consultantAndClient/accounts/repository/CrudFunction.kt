package com.consultantAndClient.accounts.repository

interface CrudFunction<T> {

    fun create(t: T): T
    fun delete(t: T)
    fun findAll(): MutableSet<T>?
    fun findById(id: Long): T?
    fun getId(): Long
}