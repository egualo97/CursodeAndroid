package mx.com.devstudios.navigationview


import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Gravity
import android.view.MenuItem
import android.view.WindowId
import android.widget.Toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

   var mDrawerToggle: ActionBarDrawerToggle? = null

    var drawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer) as DrawerLayout
        navigationView = findViewById(R.id.navigationview) as NavigationView

        setupNavigationView()
    }


        private fun setupNavigationView() {
            mDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close)

            drawerLayout!!.addDrawerListener(mDrawerToggle!!)

            navigationView!!.setNavigationItemSelectedListener(this)
        }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "Elemento seleccionado", Toast.LENGTH_SHORT).show()
        drawerLayout!!.closeDrawer(Gravity.START)

        if (!item.isChecked){
            Toast.makeText(this, "Click Item Menu",Toast.LENGTH_SHORT).show()
            item.setChecked(true)
            val itemId : Int = item.itemId
            navigate(itemId)
        }

        return true
    }

    private fun navigate(itemId: Int) {
        when(itemId){
            R.id.nav_home -> changeFragment(PrimerFragment())
            R.id.nav_perfil -> changeFragment(SegundoFragment())
        }

    }
    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
                .replace(R.id.container,fragment)
                .addToBackStack("ASD")
                .commit()
    }

    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)){
            drawerLayout!!.closeDrawer(GravityCompat.START);

        }else{
            super.onBackPressed()
        }

    }
}



