package com.joelpigem.projectecafeteria

import com.joelpigem.projectecafeteria.R

//class DataSource {
object DataSourceUsers {
    var users: MutableList<UsersModel> = mutableListOf (
        UsersModel("Joel", "joel@gmail.com", "12345"),
        UsersModel("Noa", "noa@gmail.com", "12345"),
        UsersModel("Joan", "joan@gmail.com", "12345"),
        UsersModel("Susanna", "susanna@gmail.com", "12345"),
        UsersModel("Mireia", "mireia@gmail.com", "12345")
    )


    fun carregarUsers(): MutableList<UsersModel> {
        return users
    }
}

