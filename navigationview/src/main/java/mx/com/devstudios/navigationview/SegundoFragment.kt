package mx.com.devstudios.navigationview

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by egual on 10/10/2017.
 */
class SegundoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return return inflater!!.inflate(R.layout.fragment_segundo,container,false)
    }
}