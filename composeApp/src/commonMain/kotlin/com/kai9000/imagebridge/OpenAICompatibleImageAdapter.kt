package com.kai9000.imagebridge

/**
 * Adapter contract for providers exposing an OpenAI-compatible image endpoint.
 *
 * This file intentionally contains no URL, credential, or HTTP-client code.
 * Wire it to Kai's existing OpenAI-compatible service implementation.
 *
 * The existing service should:
 *  - use its configured base URL
 *  - use its existing credential provider
 *  - send the model id and supported image parameters
 *  - decode URL/base64 image results
 *  - save bytes through Kai's existing sandbox/file-result mechanism
 */
interface OpenAICompatibleImageAdapter {
    suspend fun generate(
        request: ImageGenerationRequest,
        model: ImageModelInfo
    ): ImageGenerationResult
}
