package com.surivalcoding.winterandroidstudy.day15_webview

import android.content.Context
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.surivalcoding.winterandroidstudy.R
import com.surivalcoding.winterandroidstudy.day15_webview.ui.theme.WinterAndroidStudyTheme

class WebViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            WinterAndroidStudyTheme {
                WebViewScreen()
            }
        }
    }
}

@Composable
fun WebViewScreen(modifier: Modifier = Modifier) {
    WebViewComponent(
        url = "https://google.com",
        modifier = Modifier.fillMaxSize(),
    )
}

@Composable
fun WebViewComponent(url: String, modifier: Modifier) {
    Scaffold {
        AndroidView(
            modifier = modifier.padding(it),
            factory = { context ->
                WebView(context).apply {
                    webViewClient = object : WebViewClient() {
                    }
                    webChromeClient = object : WebChromeClient() {
                        override fun onJsAlert(
                            view: WebView?,
                            url: String?,
                            message: String?,
                            result: JsResult?
                        ): Boolean {
                            // 나만의 다이얼로그 표시
                            return false
                        }
                    }
                    settings.apply {
                        javaScriptEnabled = true  // JavaScript 활성화
                        domStorageEnabled = true  // DOM Storage 활성화
                    }
                    addJavascriptInterface(
                        WebAppInterface { message ->
                            println(message)
                        },
                        "ChannelName"
                    )
    //                loadUrl(url)
                    loadData(
                        getRawResource(context, R.raw.post),
                        "text/html",
                        "UTF-8",
                    )
                }
            },
            update = { webView ->
    //            webView.loadUrl(url)
            }
        )
    }
}

class WebAppInterface(
    private val onMessageReceived: (String) -> Unit,
) {
    // Web 에서 Native로 호출할 때
    @JavascriptInterface
    fun sendMessage(message: String) {
        onMessageReceived(message)
    }

    @JavascriptInterface
    fun showToast(message: String) {
        println(message)
    }
}

fun getRawResource(context: Context, resourceId: Int): String {
    return context.resources.openRawResource(resourceId).use { inputStream ->
        inputStream.bufferedReader().use {
            it.readText()
        }
    }
}