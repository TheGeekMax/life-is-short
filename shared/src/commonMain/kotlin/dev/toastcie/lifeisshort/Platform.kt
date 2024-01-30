package dev.toastcie.lifeisshort

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform