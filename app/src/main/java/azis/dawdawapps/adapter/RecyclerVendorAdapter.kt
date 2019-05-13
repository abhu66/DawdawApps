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
import azis.dawdawapps.model.Vendor

import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class RecyclerVendorAdapter(private val vendor :List<Vendor>, private val listener: (Vendor) -> Unit) : RecyclerView.Adapter<VendorHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorHolder {
        return VendorHolder(VendorUI().createView(AnkoContext.create(parent.context, parent)))
    }


    override fun getItemCount(): Int = vendor.size

    override fun onBindViewHolder(p0: VendorHolder, p1: Int) {
        p0.bindVendor(vendor[p1],listener)
    }
}

class VendorUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(1)
                orientation = LinearLayout.HORIZONTAL

                cardView {
                    lparams(width = matchParent, height = dip(60))
                    backgroundColor = ContextCompat.getColor(context,R.color.colorPrimary)

                    textView {
                        id = R.id.name_vendor
                        textSize = 16f
                        textColor = ContextCompat.getColor(context,R.color.colorWhite)

                    }.lparams(width= wrapContent, height = wrapContent){
                        margin = dip(12)
                        gravity = Gravity.CENTER or Gravity.START
                    }
                }
            }
        }
    }
}

class VendorHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val vendorName: TextView = view.findViewById(R.id.name_vendor)
    fun bindVendor(vendors: Vendor, listener: (Vendor) -> Unit) {
        vendorName.text = vendors.name
        itemView.setOnClickListener {
            listener(vendors)
        }
    }

}

