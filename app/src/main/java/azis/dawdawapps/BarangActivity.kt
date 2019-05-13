package azis.dawdawapps


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.view.Menu
import android.widget.LinearLayout

import azis.dawdawapps.adapter.RecyclerDataBarangAdapter

import azis.dawdawapps.model.Barang


import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class BarangActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerDataBarangAdapter
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var listBarangRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "List Data Barang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val listBarang = listOf(
            Barang(id = "1", name = "Barang 1",harga = "200000"),
            Barang(id = "2", name = "Barang 2",harga = "250000"),
            Barang(id = "3", name = "Barang 3",harga = "100000"),
            Barang(id = "4", name = "Barang 4",harga = "150000"),
            Barang(id = "5", name = "Barang 5",harga = "200000"),
            Barang(id = "6", name = "Barang 6",harga = "220000"),
            Barang(id = "7", name = "Barang 7",harga = "500000"),
            Barang(id = "8", name = "Barang 8",harga = "400000")
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

                    listBarangRv = recyclerView {
                        lparams (width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(context)
                    }
                }
            }
            adapter = RecyclerDataBarangAdapter(listBarang){
               snackbar(it.name).show()
            }
            listBarangRv.adapter = adapter
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
