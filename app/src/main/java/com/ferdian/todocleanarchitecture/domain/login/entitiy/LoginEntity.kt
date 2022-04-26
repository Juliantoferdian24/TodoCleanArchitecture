package com.ferdian.todocleanarchitecture.domain.login.entitiy

data class LoginEntity(
    var id : Int,
    var name: String,
    var email: String,
    var token: String
)