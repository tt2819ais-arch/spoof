package com.cameraspoof.data.model

enum class SpoofMode(val displayName: String, val description: String) {
    STATIC_JPEG(
        "Static JPEG",
        "Direct JPEG injection without modification"
    ),
    REGENERATED(
        "Regenerated Image",
        "New EXIF metadata, timestamp and random filename"
    ),
    PSEUDO_LIVE(
        "Pseudo Live Preview",
        "1-2 second fake camera preview before returning image"
    )
}
