package com.consultantAndClient.accounts

import com.consultantAndClient.accounts.model.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AccountsApplication

fun main(args: Array<String>) {
    CreateFirstData()
    runApplication<AccountsApplication>(*args)
}

class CreateFirstData {
    var consultants: MutableSet<Consultant> = mutableSetOf(
        Consultant(1, "John", "Lake","test@mail.com", "123", RoleConsultant.MASTER),
        Consultant(2, "Mike", "Gross","test@mail.com", "333", RoleConsultant.REPORT),
        Consultant(3, "Anna", "Karenina","test@mail.com", "111", RoleConsultant.VIEW)
    )

    var bankUsers: MutableSet<Employee> = mutableSetOf(
        Employee(1, "Bob", "Martin", "111", RoleUser.MASTER),
        Employee(2, "Tom", "Tor", "222", RoleUser.VIEW)
    )

    var solarUsers: MutableSet<Employee> = mutableSetOf(
        Employee(1, "Lev", "Tolstoy", "888", RoleUser.MASTER),
        Employee(2, "Stiv", "Oblonsky", "333", RoleUser.VIEW)
    )

    var animalWorldUsers: MutableSet<Employee> = mutableSetOf(
        Employee(1, "Alexandr", "Pushkin", "777", RoleUser.MASTER),
        Employee(2, "Natalia", "Goncharova", "555", RoleUser.VIEW)
    )

    var companies: MutableSet<Company> = mutableSetOf(
        Company(1, "Bank Number One", "0123456789", StatusOfCompany.CONTRACT_SIGNED, bankUsers),
        Company(2, "SOLAR and Co", "555555555", StatusOfCompany.CONTRACT_SIGNED, solarUsers),
        Company(3, "Animal WORLD", "33333333333", StatusOfCompany.CONTRACT_SIGNED, animalWorldUsers)
    )


}