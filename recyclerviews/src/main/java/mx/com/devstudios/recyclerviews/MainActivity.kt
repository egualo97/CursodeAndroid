package mx.com.devstudios.recyclerviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.AbsListView
import android.widget.GridLayout
import android.widget.Toast
import java.text.FieldPosition

class MainActivity : AppCompatActivity(),MyRecycleAdapter.OnItemClickListener {

    data class ItemRow(val title:String,val subtitle:String)

    var recylerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

    }
    fun setupRecyclerView(){
        recylerView = findViewById(R.id.recycle_view) as RecyclerView

        recylerView?.layoutManager = GridLayoutManager(this,2)
        val adapter = MyRecycleAdapter(createElements(),this)
        recylerView?.adapter = adapter
    }

    private fun createElements(): ArrayList<ItemRow> {
        val elements = ArrayList<ItemRow>()
        for(i in 0..40){
            elements.add(ItemRow("Titulo $i", "Subtitulo $i"))
        }
        return elements
    }
    override fun onItemClick(position: Int, item: MainActivity.ItemRow){
        MaterialDialog.Builder(this)
                .title("Titulo")
                .content("Item:${item.title}")
                .positiveText("Aceptar")
                .negativeText("Cancelar")
                .onPositive{dialog,which ->

                }
                .show()
    }
}

