package studytask.murillo.borges.moreira

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class TelaWebActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telaweb)

        // Inicialize o WebView
        webView = findViewById(R.id.webView)

        // Ative o JavaScript no WebView
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Defina um WebViewClient para garantir que os links abram dentro do WebView
        webView.webViewClient = WebViewClient()

        // Carregue a URL desejada
        val url = intent.getStringExtra("URL") // Recebe a URL que será aberta
        if (url != null) {
            webView.loadUrl(url)
        }
    }

    // Sobrescreva o método onBackPressed para permitir navegação para trás no WebView
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
