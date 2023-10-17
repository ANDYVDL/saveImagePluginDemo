package com.demo.saveimage.capacitor

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.util.Log
import java.io.File

object FileDownloader {
    private var downloadManager: DownloadManager? = null
    private var downloadID: Long = -1
    private val handler = Handler(Looper.getMainLooper())
    private const val downloadCheckInterval: Long = 1000 // Check download status every 1 second
    private var callback: DownloadCallback? = null

    fun initialize(context: Context) {
        downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    }

    fun downloadFile(context: Context, fileUrl: String, downloadCallback: DownloadCallback) {
        val uri = Uri.parse(fileUrl)
        val fileName = File(uri.path).name // Extract the filename from the URL
        val destinationDir = Environment.DIRECTORY_DOWNLOADS
        callback = downloadCallback

        val request = DownloadManager.Request(uri)
            .setTitle(fileName)
            .setDestinationInExternalPublicDir(destinationDir, fileName)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)

        downloadID = downloadManager?.enqueue(request) ?: -1

        // Periodically check download status
        checkDownloadStatus(context)
    }

    @SuppressLint("Range")
    private fun checkDownloadStatus(context: Context) {
        val query = DownloadManager.Query()
        query.setFilterById(downloadID)

        handler.postDelayed({
            val cursor = downloadManager?.query(query)
            if (cursor != null && cursor.moveToFirst()) {
                when (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))) {
                    DownloadManager.STATUS_SUCCESSFUL -> {
                        // Download completed
                        callback?.onDownloadComplete()
                    }

                    DownloadManager.STATUS_FAILED -> {
                        // Download failed
                        callback?.onDownloadFailed()
                    }

                    else -> {
                        // Continue checking download status
                        checkDownloadStatus(context)
                    }
                }
            } else {
                callback?.onDownloadCancelled()
                // Download not found in the DownloadManager; it may have been removed
            }
        }, downloadCheckInterval)
    }
}