package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model

import kotlinx.serialization.Serializable

@Serializable
data class Excuse(
    val id: Int,
    val excuse: String,
    val category: String
)
