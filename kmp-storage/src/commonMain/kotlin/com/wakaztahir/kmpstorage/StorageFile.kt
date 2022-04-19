package com.wakaztahir.kmpstorage

expect class StorageFile(pathName: String) {

    fun getName(): String
    fun getParent(): String
    fun getParentFile(): StorageFile
    fun getPath(): String
    fun isAbsolute(): Boolean
    fun getAbsolutePath(): String
    fun canRead(): Boolean
    fun canWrite(): Boolean
    fun exists(): Boolean
    fun isDirectory(): Boolean
    fun isFile(): Boolean
    fun isHidden(): Boolean
    fun lastModified(): Long
    fun length(): Long
    fun createNewFile(): Boolean
    fun delete(): Boolean
    fun deleteOnExit()
    fun list(): Array<String>
    fun listFiles(): Array<StorageFile>?
    fun mkdir(): Boolean
    fun mkdirs(): Boolean
    fun renameTo(dest: StorageFile): Boolean
    fun setLastModified(time: Long): Boolean
    fun setReadOnly(): Boolean
    fun setWritable(writable: Boolean, ownerOnly: Boolean): Boolean
    fun setWritable(writable: Boolean): Boolean
    fun setReadable(readable: Boolean, ownerOnly: Boolean): Boolean
    fun setReadable(readable: Boolean): Boolean
    fun getTotalSpace(): Long
    fun getFreeSpace(): Long
    fun getUsableSpace(): Long

}

/** applies the apply function on this file and every directory & file inside it **/
fun StorageFile.recursiveForEach(
    apply: (StorageFile) -> Unit
) {
    if (exists()) {
        val files = listFiles()
        if (files != null) {
            for (i in files.indices) {
                if (files[i].isDirectory()) {
                    files[i].recursiveForEach(apply)
                } else {
                    apply(files[i])
                }
            }
        }
    }
    return apply(this)
}

expect fun StorageFile.readAsStr(): String

expect fun StorageFile.getInputStream() : StorageInputStream

expect fun StorageFile.getOutputStream() : StorageOutputStream

expect fun StorageFile.write(str: String)

expect fun StorageFile.resolveTo(path: String): StorageFile

expect fun StorageFile.resolveTo(file: StorageFile): StorageFile

expect fun StorageFile.toUriString(): String

expect fun StorageFile.getNameWithoutExtension(): String