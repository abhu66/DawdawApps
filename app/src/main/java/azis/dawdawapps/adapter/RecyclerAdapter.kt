package azis.dawdawapps.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import azis.dawdawapps.R
import azis.dawdawapps.model.MenuItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_menu.view.*

class RecyclerAdapter(private val context: Context, private val menuItems :List<MenuItem>, private val listener: (MenuItem) -> Unit) : RecyclerView.Adapter<MenuItemHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MenuItemHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_menu, p0, false)
        return MenuItemHolder(v)
    }

    override fun getItemCount(): Int = menuItems.size

    override fun onBindViewHolder(p0: MenuItemHolder, p1: Int) {
        p0.bindMenuItem(menuItems[p1],listener)
    }
}
class MenuItemHolder(view: View) : RecyclerView.ViewHolder(view) {


    fun bindMenuItem(menuItem: MenuItem, listener: (MenuItem) -> Unit) {
        itemView.nama_item.text = menuItem.name
        Picasso.get().load(menuItem.image).into(itemView.image_item)

        itemView.setOnClickListener {
            listener(menuItem)
        }
    }

}