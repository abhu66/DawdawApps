package azis.dawdawapps.adapter


import android.R.attr.*
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.Gravity

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import azis.dawdawapps.R
import azis.dawdawapps.model.Barang

import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class RecyclerDataBarangAdapter(private val vendor :List<Barang>, private val listener: (Barang) -> Unit) : RecyclerView.Adapter<BarangHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangHolder {
        return BarangHolder(BarangUI().createView(AnkoContext.create(parent.context, parent)))
    }


    override fun getItemCount(): Int = vendor.size

    override fun onBindViewHolder(p0: BarangHolder, p1: Int) {
        p0.bindBarang(vendor[p1],listener)
    }
}

class BarangUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(1)
                orientation = LinearLayout.HORIZONTAL

                cardView {
                    lparams(width = matchParent, height = dip(60))
                    backgroundColor = ContextCompat.getColor(context,R.color.colorPrimary)
                    foreground.apply {
                         selectableItemBackground
                    }
                    textView {
                        id = R.id.nama_barang
                        textSize = 16f
                        textColor = ContextCompat.getColor(context,R.color.colorWhite)

                    }.lparams(width= wrapContent, height = wrapContent){
                        margin = dip(12)
                        gravity = Gravity.CENTER or Gravity.START
                    }
                    textView {
                        id = R.id.harga_barang
                        textSize = 16f
                        textColor = ContextCompat.getColor(context,R.color.colorWhite)

                    }.lparams(width= wrapContent, height = wrapContent){
                        margin = dip(12)
                        gravity = Gravity.CENTER
                    }
                }
            }
        }
    }
}

class BarangHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val namaBarang: TextView = view.findViewById(R.id.nama_barang)
    private val hargaBarang: TextView = view.findViewById(R.id.harga_barang)
    fun bindBarang(barang: Barang, listener: (Barang) -> Unit) {
        namaBarang.text = barang.name
        hargaBarang.text = barang.harga
        itemView.setOnClickListener {
            listener(barang)
        }
    }

}

