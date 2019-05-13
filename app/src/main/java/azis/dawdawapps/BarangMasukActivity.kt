package azis.dawdawapps

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.incoming_layout.*
import android.content.Intent
import android.support.design.widget.Snackbar



class BarangMasukActivity : AppCompatActivity() {


    private  var  vendorId  : String?= ""
    private  var vendorName : String?= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.incoming_layout)
        supportActionBar?.title = "Barang Masuk"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        btn_batal.setOnClickListener {
            finish()
        }

        vendor_field_name.setOnClickListener {
            val i = Intent(this, VendorActivity::class.java)
            startActivityForResult(i, 1)
        }

        button_simpan.setOnClickListener {
            val snack = Snackbar.make(it,"Id Vendor adalah : $vendorId",Snackbar.LENGTH_LONG)
            snack.show()
        }
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

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                 vendorId = data?.getStringExtra("id")
                 vendorName = data?.getStringExtra("vendorName")
                 val vendor = "$vendorId - $vendorName"
                vendor_field_name.setText(vendor)
            }
        }
    }


}
