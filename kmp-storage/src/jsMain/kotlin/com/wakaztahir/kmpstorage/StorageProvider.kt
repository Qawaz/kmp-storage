package com.wakaztahir.kmpstorage

actual object StorageProvider {
    actual val separator: String get() = "/"

    actual fun createTemporaryFile(prefix: String, suffix: String?): StorageFile {
        throw UnsupportedOperationException()
    }
}