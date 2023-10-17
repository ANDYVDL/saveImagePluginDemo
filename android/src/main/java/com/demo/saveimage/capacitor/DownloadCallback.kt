package com.demo.saveimage.capacitor

interface DownloadCallback {
    fun onDownloadComplete()
    fun onDownloadFailed()
    fun onDownloadCancelled()
}