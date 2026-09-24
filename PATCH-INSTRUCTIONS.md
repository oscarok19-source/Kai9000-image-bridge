# Kai9000 native image bridge — integration patch

This package is deliberately separated into a portable contract and a small
Skill because Kai's exact internal provider classes can move between releases.

## What this patch adds

1. `ImageGenerationBridge`
2. Serializable request/result/model types
3. A stable two-tool contract:
   - `image_models`
   - `image_generate`
4. A Skill that calls those native tools.

## Where to connect it

In the current Kai source tree, find the code that:

- registers the normal AI tools
- resolves the currently configured service/model
- performs provider requests
- writes sandbox/tool output files

Register two tools there.

### image_models

Return all configured models for which the provider adapter declares:
- text-to-image, or
- image-to-image.

Do not return API credentials.

### image_generate

Resolve `modelId` through Kai's existing service/model configuration.
Dispatch to the provider adapter's image-generation endpoint.

Provider adapters should normalize their responses to:
`ImageGenerationResult(success, modelId, providerId, files, error)`.

### Important

Do not implement this by reading the Settings JSON from the Linux sandbox.
Do not copy API keys into environment variables. The native bridge exists
specifically to keep credentials on the application side.

## Why this is the correct architecture

Kai's public repository documents:
- multi-service providers,
- model selection,
- image attachments,
- Linux sandbox,
- Skills.

Its changelog also documents per-model image capability gating and the Skills
system. The missing piece for this use case is a native tool that exposes
image *generation* rather than merely image *input*.

This patch supplies that missing interface while leaving provider-specific
authentication inside Kai.
