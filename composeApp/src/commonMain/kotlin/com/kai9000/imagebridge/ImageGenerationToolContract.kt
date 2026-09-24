package com.kai9000.imagebridge

/**
 * JSON contract between Kai's native tool and a Skill.
 *
 * The tool should expose two operations:
 *
 * image_models
 * image_generate
 *
 * Example image_models result:
 * {
 *   "models": [
 *     {
 *       "id": "provider/model-id",
 *       "displayName": "My Image Model",
 *       "providerId": "provider",
 *       "capabilities": {
 *         "textToImage": true,
 *         "imageToImage": true,
 *         "transparentBackground": true,
 *         "supportedSizes": ["1024x1024"],
 *         "supportedAspectRatios": ["1:1","16:9"]
 *       }
 *     }
 *   ]
 * }
 *
 * Example image_generate arguments:
 * {
 *   "prompt": "...",
 *   "modelId": "provider/model-id",
 *   "inputImages": ["/sandbox/path/reference.png"],
 *   "size": "1024x1024",
 *   "aspectRatio": "16:9",
 *   "transparentBackground": true,
 *   "count": 1
 * }
 */
object ImageGenerationToolContract {
    const val MODELS_TOOL = "image_models"
    const val GENERATE_TOOL = "image_generate"
}
