package mx.com.devstudios.fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.zip.Inflater

/**
 * Created by egual on 02/10/2017.
 */
    class ThirdFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
       val view = inflater!!.inflate(R.layout.fragment_third, container, false)
        return view
    }
}