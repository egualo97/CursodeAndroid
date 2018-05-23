package mx.com.devstudios.fragments

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                val layoutContainer = findViewById(R.id.content)
                /**
                 * Conseguimos la orinetacion del dispositivo
                 * si es 1 esrta en vertical
                 * 2 horizontal
                 */
                val orientation = resources.configuration.orientation

                if (orientation == 1) {
                    layoutContainer.visibility = View.GONE
                } else {


            val fragment = ThirdFragment()
            val fragmentManager = supportFragmentManager

            fragmentManager.beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit()

        }
    }
}