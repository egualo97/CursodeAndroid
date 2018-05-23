package mx.com.devstudios.fragmentexcercise

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by egual on 03/10/2017.
 */
class SecondFragment : Fragment() {

    class SecondFragment : android.support.v4.app.Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
            val view = inflater!!.inflate(R.layout.second_fragment, container, false)
            return view
}
    }
}