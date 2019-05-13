package azis.dawdawapps


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.login_layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        supportActionBar?.hide()

        loginProses()
    }

    private fun loginProses(){
        button_login.setOnClickListener {
            val intent = Intent(this@MainActivity, DashboardActivity::class.java)
           //val bundle = Bundle()
            intent.putExtra("username",field_username.text)
            intent.putExtra("password",field_password.text)
           // bundle.putParcelable("user",field_username.text.toString())
           // intent.putExtra("myBundle",bundle)
            startActivity(intent)
        }

    }
}
