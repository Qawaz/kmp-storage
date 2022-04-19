@file:JvmName("AndroidStorageOutputStream")

package com.wakaztahir.kmpstorage

import java.io.OutputStream

actual typealias StorageOutputStream = OutputStream

actual fun StorageOutputStream.write(stream: StorageInputStream) {
    val buffer = ByteArray(2048)
    var n: Int = stream.read(buffer)
    while (n > 0) {
        write(buffer, 0, n)
        n = stream.read(buffer)
    }
}