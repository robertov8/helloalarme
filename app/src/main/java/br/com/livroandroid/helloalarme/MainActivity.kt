package br.com.livroandroid.helloalarme

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.livroandroid.helloalarme.extensions.onClick
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClick(R.id.btAgendar) { agendar() }
        onClick(R.id.btAgendarComRepeat) { agendarComRepeat() }
        onClick(R.id.btCancelar) { cancelar() }
    }

    // Data/Tempo para agendar o alarme
    private fun getTime(): Long {
        val c = Calendar.getInstance()
        c.timeInMillis = System.currentTimeMillis()
        c.add(Calendar.SECOND, 5)
        return c.timeInMillis
    }

    private fun agendar() {
        val intent = Intent(LembremeDeComerReceiver.ACTION)
        // Agenda para daqui a 5 segundos
        AlarmUtil.schedule(this, intent, getTime())
        toast("Alarme agendado.")
    }

    private fun agendarComRepeat() {
        val intent = Intent(LembremeDeComerReceiver.ACTION)
        // Agenda para daqui a 5 segundos, repete a cada 30 segundos
        AlarmUtil.scheduleRepeat(this, intent, getTime(), (30 * 1000).toLong())
        toast("Alarme agendado com repetir")
    }

    private fun cancelar() {
        val intent = Intent(LembremeDeComerReceiver.ACTION)
        AlarmUtil.cancel(this, intent)
        toast("Alarme cancelado")
    }

    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }
}
