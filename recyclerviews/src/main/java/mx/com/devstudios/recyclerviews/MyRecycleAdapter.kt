package mx.com.devstudios.recyclerviews

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by egual on 24/10/2017.
 */
class MyRecycleAdapter(val items: List<MainActivity.ItemRow>, val listener:OnItemClickListener)
    : RecyclerView.Adapter<MyRecycleAdapter.MyRecycleViewHolder>() {
    //Indicamos cuentos elementos creara el RecycleView

    override fun getItemCount(): Int{
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyRecycleViewHolder {
        val rowView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item,parent,false)
        return MyRecycleViewHolder(rowView)
    }



    override fun onBindViewHolder(holder: MyRecycleViewHolder?, position: Int) {
        holder?.tvTitle?.text = items[position].title
        holder?.tvSubtile?.text = items[position].subtitle
        holder?.itemView?.setOnClickListener{ listener.onItemClick(position,items[position]) }


    }

    class MyRecycleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var tvTitle :TextView? = null
        var tvSubtile: TextView? = null
        var imgIcon: ImageView? = null

 init {
      tvTitle = itemView.findViewById(R.id.row_item)
     tvSubtile = itemView.findViewById(R.id.row_subtitle)
     imgIcon = itemView.findViewById(R.id.row_item)

       }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int,itemRow: MainActivity.ItemRow);
    }
}