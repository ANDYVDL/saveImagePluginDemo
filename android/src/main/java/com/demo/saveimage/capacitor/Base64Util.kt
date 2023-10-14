package com.demo.saveimage.capacitor

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaScannerConnection
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object Base64Util {


    fun decodeBase64ToBitmap(base64String : String): Bitmap? {
        return try {
            val bytes = android.util.Base64.decode(base64String, android.util.Base64.DEFAULT)
            BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        }catch (e : Exception){
            e.printStackTrace()
            null
        }
    }

    fun saveBitmapAsPng(bitmap: Bitmap, context: Context,folderName :String): String? {
        val fileName = "image.png"
        val directory = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
            folderName
        )
        directory.mkdirs()
        val file = File(directory, fileName)

        try {
            val out = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.close()

            // Tell the media scanner to scan for the newly saved file
            MediaScannerConnection.scanFile(
                context,
                arrayOf(file.toString()),
                null,
                null
            )
            return file.absolutePath
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}