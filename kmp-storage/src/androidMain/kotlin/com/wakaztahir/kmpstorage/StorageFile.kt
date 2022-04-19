@file:JvmName("AndroidStorageFile")

package com.wakaztahir.kmpstorage

import android.net.Uri
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

actual typealias StorageFile = File

actual fun StorageFile.write(str: String) {
    val outputStream = getOutputStream()
    val writer = OutputStreamWriter(outputStream)
    val bufferedWriter = BufferedWriter(writer)
    bufferedWriter.write(str)
    bufferedWriter.close()
    writer.close()
    outputStream.close()
}

actual fun StorageFile.getInputStream(): StorageInputStream = inputStream()

actual fun StorageFile.getOutputStream(): StorageOutputStream = outputStream()

actual fun StorageFile.readAsStr(): String = this.readText()

actual fun StorageFile.resolveTo(path: String): StorageFile = this.resolve(relative = path)

actual fun StorageFile.resolveTo(file: StorageFile): StorageFile = this.resolve(relative = file)

actual fun StorageFile.toUriString(): String = Uri.fromFile(this).toString()

actual fun StorageFile.getNameWithoutExtension(): String = nameWithoutExtension