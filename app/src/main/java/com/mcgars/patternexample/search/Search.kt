package com.mcgars.patternexample.search

import android.content.Context
import android.net.Uri
import java.io.Serializable
import java.net.URI


interface Search : Serializable{
    fun append(uri: Uri.Builder)
    fun getTitle(): String
    fun toString(context: Context): String
}