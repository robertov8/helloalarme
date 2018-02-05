package br.com.livroandroid.helloalarme

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

class LembremeDeComerReceiver : BroadcastReceiver(){
    companion object {
        // Constantes
        val TAG = "livroandroid"
        val ACTION = "br.com.livroandroid.helloalarme.LEMBREME_DE_COMER"
    }

    override fun onReceive(context: Context, p1: Intent) {
        Log.d(TAG, "Você precisa comer: ${Date()}")
        val notifiIntent = Intent(context, MainActivity::class.java)
        NotificationUtil.create(context, 1, notifiIntent, "Hora de comer algo...", "Que tal uma fruta?")
    }
}