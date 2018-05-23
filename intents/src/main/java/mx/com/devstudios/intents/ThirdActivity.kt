package mx.com.devstudios.intents

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val message = intent.extras.get("key1")
        val numero = intent.extras.get("key2")
        Log.d("myLog","Mensage: $message")
        Log.d("myLog","Numero: $numero")


    }

}
