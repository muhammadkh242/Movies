package com.example.moviesmvvm.network

interface RemoteSource {
    fun enqueueCall(networkDelegate: NetworkDelegate)
}