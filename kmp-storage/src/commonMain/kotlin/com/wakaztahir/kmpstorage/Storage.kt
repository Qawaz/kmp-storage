package com.wakaztahir.kmpstorage

interface Storage {

    val rootDir: StorageFile

    fun getFreeSpace(dir: StorageFile = rootDir): Long? = kotlin.runCatching { dir.getFreeSpace() }.getOrNull()

    /** creates a file in the root directory **/
    fun createFile(fileName: String): StorageFile =
        rootDir.resolveTo(fileName).also { it.createNewFile() }

}
