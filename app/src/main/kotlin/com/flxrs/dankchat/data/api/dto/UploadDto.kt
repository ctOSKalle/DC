package com.flxrs.dankchat.data.api.dto

import java.time.Instant

data class UploadDto(
    val imageLink: String,
    val deleteLink: String?,
    val timestamp: Instant
)