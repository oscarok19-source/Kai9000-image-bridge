---
name: kai-image-models
description: Generate and edit images using the image models configured in Kai 9000. Use for requests to create, draw, render, transform, edit, inpaint, remove backgrounds, make transparent PNGs, or generate image variants.
---

# Kai Image Models — native bridge

This skill assumes the Kai application has installed the native `image_models`
and `image_generate` tools.

## Rules

- Use `image_models` first when the user asks which image models are available,
  or when model capabilities are unknown.
- If the user names a model, pass its exact id as `modelId`.
- Otherwise choose an image-capable model from the models returned by Kai.
- For edits, pass the attached image path as `inputImages`.
- Do not expose API keys or provider credentials.
- Do not substitute an external provider when the native bridge is available.
- Preserve the user's requested aspect ratio, resolution, transparency, and count
  when supported by the selected model.
- If a requested option is unsupported, omit that option and tell the user.

## Natural-language triggers

Use this skill for:
- "genera una imagen"
- "crea un dibujo"
- "haz una imagen"
- "edita esta imagen"
- "quita el fondo"
- "hazlo transparente"
- "usa el modelo X"
- "genera 4 variantes"

## Generation

1. Call `image_models` if model/capabilities are needed.
2. Call `image_generate`.
3. The native tool returns sandbox-visible output paths.
4. Return/show those images in Kai's normal attachment/image result pipeline.

## Never

- Read Kai's settings database directly.
- Read encrypted credentials.
- Ask the user to paste an API key when a configured Kai provider is available.
- Claim success unless the native tool reports `success: true`.
