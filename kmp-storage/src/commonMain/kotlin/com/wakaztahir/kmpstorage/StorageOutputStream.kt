package com.wakaztahir.kmpstorage

expect abstract class StorageOutputStream {
    fun close()
}

expect fun StorageOutputStream.write(stream : StorageInputStream)