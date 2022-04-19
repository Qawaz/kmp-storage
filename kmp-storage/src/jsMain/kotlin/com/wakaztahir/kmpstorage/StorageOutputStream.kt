package com.wakaztahir.kmpstorage

actual abstract class StorageOutputStream {
    actual fun close() {
        throw UnsupportedOperationException()
    }
}

actual fun StorageOutputStream.write(stream: StorageInputStream) {
    throw UnsupportedOperationException()
}