package com.example.whatsappclone.data.entity

import java.io.Serializable

data class Message(
    val name: String,
    val message: String,
    val time: String,
    val image: String
) : Serializable {
}