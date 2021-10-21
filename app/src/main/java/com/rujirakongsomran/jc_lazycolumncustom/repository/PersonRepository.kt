package com.rujirakongsomran.jc_lazycolumncustom.repository

import com.rujirakongsomran.jc_lazycolumncustom.model.Person

class PersonRepository {
    fun getAllData(): List<Person> {
        return listOf(
            Person(
                id = 0,
                firstName = "Let",
                lastName = "Also",
                age = 20
            ),
            Person(
                id = 1,
                firstName = "Get",
                lastName = "Set",
                age = 15
            ),
            Person(
                id = 2,
                firstName = "Jetpack",
                lastName = "Compose",
                age = 20
            ),
            Person(
                id = 3,
                firstName = "Navigation",
                lastName = "Component",
                age = 15
            ),
            Person(
                id = 4,
                firstName = "DataStore",
                lastName = "View",
                age = 20
            ),
            Person(
                id = 5,
                firstName = "Room",
                lastName = "Persistence",
                age = 15
            ),
        )
    }
}