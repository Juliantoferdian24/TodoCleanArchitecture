package com.ferdian.todocleanarchitecture.domain.login.entity

data class LoginEntity(
    var id : Int,
    var name: String,
    var email: String,
    var token: String
)