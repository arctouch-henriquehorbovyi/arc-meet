package com.arctouch.arcmeet.data

data class Attendee(
    val name: String,
    val imageUrl: String?,
    val soundStatus: SoundStatus,
)

enum class SoundStatus {
    MUTE,
    UNMUTE,
    SPEAKING,
    PAUSED,
}

val mockedAttendees = listOf(
    Attendee(
        name = "Thiago",
        imageUrl = "https://ca.slack-edge.com/T03AA9FPU-U03PMH83T0E-7a5813692b33-512",
        soundStatus = SoundStatus.PAUSED,
    ),
    Attendee(
        name = "John Doe",
        imageUrl = null,
        soundStatus = SoundStatus.MUTE,
    ),
    Attendee(
        name = "Jane Smith",
        imageUrl = null,
        soundStatus = SoundStatus.UNMUTE,
    ),
    Attendee(
        name = "Alice Johnson",
        imageUrl = null,
        soundStatus = SoundStatus.SPEAKING,
    ),
)
