package com.example.sem08

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var btnPopup: Button
    private lateinit var tvBienvenida: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre = intent.getStringExtra("nombre")
        tvBienvenida = findViewById(R.id.tvBienvenida)
        tvBienvenida.text = getString(R.string.bienvenido_usuario, nombre)

        webView = findViewById(R.id.webViewUNS)
        btnPopup = findViewById(R.id.btnPopup)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.uns.edu.pe")

        registerForContextMenu(webView)

        btnPopup.setOnClickListener {
            val popup = PopupMenu(this, btnPopup)
            popup.menuInflater.inflate(R.menu.menu_popup, popup.menu)
            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_contacto -> {
                        startActivity(Intent(this, ContactoActivity::class.java))
                    }
                    R.id.menu_eventos -> {
                        startActivity(Intent(this, EventosActivity::class.java))
                    }
                    else -> {
                        Toast.makeText(this, getString(R.string.seleccionado, it.title), Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
            popup.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_informacion -> {
                Toast.makeText(this, getString(R.string.info_uns), Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_salir -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_contextual, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_recargar -> {
                webView.reload()
                return true
            }
            R.id.menu_atras -> {
                if (webView.canGoBack()) webView.goBack()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}
