package com.kai9000.imagebridge

/**
 * Native bridge used by Skills/tools to access image-capable models configured
 * in Kai itself.
 *
 * Implement this in the same service layer that already owns the user's
 * configured providers and credentials. Do NOT expose API keys to the Linux
 * sandbox or to Skill scripts.
 */
interface ImageGenerationBridge {
    suspend fun listImageModels(): List<ImageModelInfo>

    suspend fun generate(
        request: ImageGenerationRequest
    ): ImageGenerationResult
}
