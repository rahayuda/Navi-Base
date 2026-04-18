package com.example.navi

import android.os.Bundle

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main) // Mengisi bingkai dengan isi dashboard
        supportActionBar?.title = "Dashboard"
    }
}