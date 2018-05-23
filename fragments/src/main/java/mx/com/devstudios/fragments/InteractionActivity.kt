package mx.com.devstudios.fragments

import android.os.Bundle
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by egual on 03/10/2017.
 */
class InteractionActivity : AppCompatActivity(), OnFragmentInteractionListener {


    override fun onCreate(onSaveInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interaction_fragment)

        val fragment = InteractionFragment.newInstace("Hola desde la activudad")
        changeFragment(fragment)
    }


    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTrasnsaction()
                .replace(R.id,container, fragment, "frag1")
                .commit()

    }
     override fun onInteraction(message: String) {
     Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        val fragment = supportFragmentManager.findFragmentByTag("frag1") as InteractionFragment;
         fragment.mostrarMensajeVuelta("Mensaje de Vuelta")
     }
}
