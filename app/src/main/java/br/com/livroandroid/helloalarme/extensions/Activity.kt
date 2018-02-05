package br.com.livroandroid.helloalarme.extensions

import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import android.view.View

// Para facilitar o setOnClickListener
fun AppCompatActivity.onClick(@IdRes viewId: Int, onClick: (v: View?) -> Unit) {
    val view = findViewById<View>(viewId)
    view.setOnClickListener { onClick(it) }
}