package mx.com.devstudios.contador

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutContainer = findViewById(R.id.fragment_frist)
        val layoutContainer = findViewById(R.id.fragment_second)

        val fragment = FirstFragment()
        val fragment = SecondFragment()
        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_frist, fragment)
                .commit()

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_second, fragment)
                .commit()

    }
}
