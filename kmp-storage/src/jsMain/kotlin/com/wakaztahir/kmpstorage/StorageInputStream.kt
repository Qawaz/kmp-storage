package com.wakaztahir.kmpstorage

actual abstract class StorageInputStream {
    actual fun close() {
        throw UnsupportedOperationException()
    }
}