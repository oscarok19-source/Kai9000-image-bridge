package com.kai9000.imagebridge

import kotlinx.serialization.Serializable

@Serializable
data class ImageModelCapabilities(
    val textToImage: Boolean = false,
    val imageToImage: Boolean = false,
    val transparentBackground: Boolean = false,
    val supportedSizes: List<String> = emptyList(),
    val supportedAspectRatios: List<String> = emptyList()
)

@Serializable
data class ImageModelInfo(
    val id: String,
    val displayName: String = id,
    val providerId: String,
    val capabilities: ImageModelCapabilities = ImageModelCapabilities()
)

@Serializable
data class ImageGenerationRequest(
    val prompt: String,
    val modelId: String? = null,
    val inputImages: List<String> = emptyList(),
    val size: String? = null,
    val aspectRatio: String? = null,
    val transparentBackground: Boolean = false,
    val count: Int = 1
)

@Serializable
data class ImageGenerationResult(
    val success: Boolean,
    val modelId: String? = null,
    val providerId: String? = null,
    val files: List<String> = emptyList(),
    val error: String? = null
)
