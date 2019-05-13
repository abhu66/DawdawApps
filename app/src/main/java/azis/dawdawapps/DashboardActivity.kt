package azis.dawdawapps



import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast

import azis.dawdawapps.adapter.RecyclerAdapter
import azis.dawdawapps.model.MenuItem
import kotlinx.android.synthetic.main.dashboard_layout.*
import org.jetbrains.anko.startActivity
class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_layout)

        val listMenu = listOf(
            MenuItem(name = "Data Barang", image = R.drawable.ic_action_asset),
            MenuItem(name = "Barang Masuk", image = R.drawable.ic_file_download_white_48dp),
            MenuItem(name = "Barang Keluar", image = R.drawable.ic_file_upload_white_48dp),
            MenuItem(name = "Supplier", image = R.drawable.ic_supplier_48dp),
            MenuItem(name = "Data Pegawai", image = R.drawable.ic_action_user),
            MenuItem(name = "Laporan", image = R.drawable.ic_action_asset)
        )

        val menuIntAdapter = RecyclerAdapter(applicationContext,listMenu){
            if(it.name == "Barang Masuk") {
                startActivity<BarangMasukActivity>()
            }
            else {
                Toast.makeText(applicationContext,it.name,Toast.LENGTH_LONG).show()
            }

        }

        rvMain.apply {
            layoutManager = GridLayoutManager(this@DashboardActivity,2)
            adapter = menuIntAdapter
        }
    }
}
