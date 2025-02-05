package com.surivalcoding.winterandroidstudy.day08

import android.content.ClipboardManager
import android.content.Context

interface ClipboardRepository {
    fun save(text: String)
    fun getText(): String
}

class ClipboardRepositoryImpl(context: Context) : ClipboardRepository {
    private val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    override fun save(text: String) {
        TODO("Not yet implemented")
    }

    override fun getText(): String {
        TODO("Not yet implemented")
    }

}