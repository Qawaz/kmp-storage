package com.wakaztahir.kmpstorage

import java.io.File

actual object StorageProvider {
    actual val separator: String get() = File.separator

    actual fun createTemporaryFile(prefix: String, suffix: String?): StorageFile {
        return File.createTempFile(prefix, suffix)
    }
}