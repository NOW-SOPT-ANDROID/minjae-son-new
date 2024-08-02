package com.sopt.now.compose.data

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val password: String,
    val nickname: String,
    val phoneNumber: String
)