package com.wakaztahir.kmpstorage

expect object StorageProvider {

    val separator: String

    fun createTemporaryFile(prefix: String, suffix: String?): StorageFile
}