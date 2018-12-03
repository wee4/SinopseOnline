package com.example.wesle.sinopseonline

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val channelId = "com.example.wesle.sinopseonline"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addListener()
}

    private fun addListener() {
        var movies =   arrayOf("Batman vs SuperMan", "Transformers", "Iron Man 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, movies)
        spinnerMovie.adapter = adapter
        spinnerMovie.setSelection(0)
        spinnerMovie.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.selectedItem.toString()
                showProperties(selectedItem)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                imgMovie.visibility = View.GONE
                txtSinopse.text = ""
            }

        }
    }

    private fun showProperties(selectedItem: String) {
        val movie :MovieEnum = when(selectedItem) {
            "Batman vs SuperMan" -> MovieEnum.BATMAN_VS_SUPERMAN
            "Transformers" -> MovieEnum.TRANSFORMERS
            "Iron Man 3" -> MovieEnum.IRON_MAN_3
            else -> MovieEnum.INVALID
        }

        imgMovie.visibility = View.VISIBLE
        imgMovie.setImageResource(movie.getImage())
        txtSinopse.text = movie.getSinopse()
        notif()
    }

    fun notif(){
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val mNotification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, channelId)
        } else {
            Notification.Builder(this)
        }.apply {
            setContentIntent(pendingIntent)
            // adicionando um ícone na notificação
            setSmallIcon(R.drawable.ic_stat_name)
            setAutoCancel(true)
            // título da notificação
            setContentTitle(spinnerMovie.selectedItem.toString())
            // mensagem da notificação
            setContentText("Leia a sinopse.....")
        }.build()
        val mNotificationId: Int = 1000
        val nManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nManager.notify(mNotificationId, mNotification)
    }
}
