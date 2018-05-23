package mx.com.devstudios.navigationview

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.ArrayList

/**
 * Created by egual on 11/10/2017.
 */
class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager)    {

   val fragmentList = ArrayList<Fragment>()
    val titleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]

    }

    override fun getCount(): Int {
        return fragmentList.size

}

    override fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }
    fun addFragment(fragment: Fragment, title:String){
        fragmentList.add(fragment)
        titleList.add(title)


    }
}