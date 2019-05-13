package azis.dawdawapps


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.view.Menu
import android.widget.LinearLayout
import android.widget.ProgressBar
import azis.dawdawapps.adapter.RecyclerVendorAdapter
import azis.dawdawapps.model.Vendor

import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class VendorActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerVendorAdapter
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var listVendorRv: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Pilih Vendor"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val listVendor = listOf(
            Vendor(id = "1", name = "Toko XXXXXXXXX1"),
            Vendor(id = "2", name = "Toko XXXXXXXXX2"),
            Vendor(id = "3", name = "Toko XXXXXXXXX3"),
            Vendor(id = "4", name = "Toko XXXXXXXXX4"),
            Vendor(id = "5", name = "Toko XXXXXXXXX5"),
            Vendor(id = "6", name = "Toko XXXXXXXXX6"),
            Vendor(id = "7", name = "Toko XXXXXXXXX7"),
            Vendor(id = "8", name = "Toko XXXXXXXXX8")
        )


       /* val vendorAdapter = RecyclerVendorAdapter(applicationContext,listVendor){
            var intent = intent
            intent.putExtra("id", it.id)
            intent.putExtra("vendorName", it.name)
            setResult(RESULT_OK, intent)
            finish()
        }*/
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(90)
            leftPadding = dip(1)
            rightPadding = dip(1)


            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(android.R.color.transparent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light)

                relativeLayout{
                    lparams (width = matchParent, height = wrapContent)

                    listVendorRv = recyclerView {
                        lparams (width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(context)
                    }

                   /* progressBar = progressBar {
                    }.lparams{
                        centerHorizontally()
                    }*/
                }
            }
            adapter = RecyclerVendorAdapter(listVendor){
                val intent = intent
                intent.putExtra("id", it.id)
                intent.putExtra("vendorName", it.name)
                setResult(RESULT_OK, intent)
                finish()
            }
            listVendorRv.adapter = adapter
        }

       /* rvVendor.apply {
            layoutManager = LinearLayoutManager(this@VendorActivity)
            adapter = vendorAdapter
        }*/
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem   ): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(
            R.menu.menu_search,
            menu
        )

        return super.onCreateOptionsMenu(menu)
    }


}
