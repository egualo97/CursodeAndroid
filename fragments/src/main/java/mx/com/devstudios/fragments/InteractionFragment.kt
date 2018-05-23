package mx.com.devstudios.fragments

import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class InteractionFragment : Fragment(){
}
       var texto: String? = null
       var callback: OnFragmentInteractionListener? = null

    class InteractionFragment : Fragment() {

        companion object {


        val ARG_TXT = "ARG_TXT"
        fun newInstance(text: String): InteractionFragment {
            //Creo una instancia de interaction fragment
            val fragment = InteractionFragment
            // Creo un bundle que guardara los datos pasados como argumentos en mi fragmneto
            val args = Bundle()
            //Le paso los paramentros al bundle
            args.putString(ARG_TXT, text)
            //Asocio mi bundle a mi fragmento
            fragment.arguments = args
            return fragment

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Recupero los argumentos del Bundle
        texto = arguments.getString(ARG_TXT)
    }

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
            val view = inflater!!.inflate(R.layout.activity_interaction_fragment, container, false)
            val tvText = view.findViewById<TextView>(R.id.tv_text)
            Toast.makeText(activity,texto,Toast.LENGTH_LONG).show()

            view.findViewById<Button>(R.id.btn).setOnClickListener(this)

            return view

        }

        override fun onAttach(context: Context?) {
            super.onAttach(context)
            if(context is OnFragmentInteractionListener)
            callback = context as OnFragmentInteractionListener

        }

        fun mostrarMensajeVuelta(messageFromActivity: String){
            Toast.makeText(activity, messageFromActivity, Toast.LENGTH_SHORT).show()
        }
             override fun onClick(p0:View?){
             callback?.onIneraction("hola desde el fragmento a la actividad")
         }
    }


