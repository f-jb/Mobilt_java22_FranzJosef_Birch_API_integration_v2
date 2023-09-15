package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fact (
    val id: String,
    val text: String,
    val source: String,
    @SerialName(value = "source_url")
    val sourceUrl: String,
    val language: String,
    val permalink: String
)