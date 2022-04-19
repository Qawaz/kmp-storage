package com.wakaztahir.kmpstorage

actual class StorageFile actual constructor(pathName: String) {

    actual fun getName(): String {
        throw UnsupportedOperationException()
    }

    actual fun getParent(): String {
        throw UnsupportedOperationException()
    }

    actual fun getParentFile(): StorageFile {
        throw UnsupportedOperationException()
    }

    actual fun getPath(): String {
        throw UnsupportedOperationException()
    }

    actual fun isAbsolute(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun getAbsolutePath(): String {
        throw UnsupportedOperationException()
    }

    actual fun canRead(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun canWrite(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun exists(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun isDirectory(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun isFile(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun isHidden(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun lastModified(): Long {
        throw UnsupportedOperationException()
    }

    actual fun length(): Long {
        throw UnsupportedOperationException()
    }

    actual fun createNewFile(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun delete(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun deleteOnExit() {
    }

    actual fun list(): Array<String> {
        throw UnsupportedOperationException()
    }

    actual fun listFiles(): Array<StorageFile>? {
        throw UnsupportedOperationException()
    }

    actual fun mkdir(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun mkdirs(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun renameTo(dest: StorageFile): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun setLastModified(time: Long): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun setReadOnly(): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun setWritable(writable: Boolean, ownerOnly: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun setWritable(writable: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun setReadable(readable: Boolean, ownerOnly: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun setReadable(readable: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    actual fun getTotalSpace(): Long {
        throw UnsupportedOperationException()
    }

    actual fun getFreeSpace(): Long {
        throw UnsupportedOperationException()
    }

    actual fun getUsableSpace(): Long {
        throw UnsupportedOperationException()
    }

}

actual fun StorageFile.write(str: String) {
    throw UnsupportedOperationException()
}

actual fun StorageFile.getInputStream(): StorageInputStream {
    throw UnsupportedOperationException()
}

actual fun StorageFile.getOutputStream(): StorageOutputStream {
    throw UnsupportedOperationException()
}

actual fun StorageFile.readAsStr(): String {
    throw UnsupportedOperationException()
}

actual fun StorageFile.resolveTo(path: String): StorageFile {
    throw UnsupportedOperationException()
}

actual fun StorageFile.resolveTo(file: StorageFile): StorageFile {
    throw UnsupportedOperationException()
}

actual fun StorageFile.toUriString(): String {
    throw UnsupportedOperationException()
}

actual fun StorageFile.getNameWithoutExtension(): String {
    throw UnsupportedOperationException()
}

