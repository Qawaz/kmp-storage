package com.wakaztahir.kmpstorage

open class BaseDirStorage(baseDir: StorageFile) : Storage {
    override val rootDir: StorageFile = baseDir
}