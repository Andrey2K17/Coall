package ag.pg13.coal

import ag.pg13.coal.Adapter.ListProviderAdapter
import ag.pg13.coal.DBHelper.DBHelper
import ag.pg13.coal.Model.Provider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_layout.*


class MainActivity : AppCompatActivity() {

    internal lateinit var db:DBHelper
    internal var lstProviders:List<Provider> = ArrayList<Provider>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(this)

        refreshData()

    }

    private fun refreshData() {
        lstProviders = db.allProviders
        val adapter = ListProviderAdapter(this@MainActivity,lstProviders, idProvider,nameProvider)
        providerList.adapter = adapter
    }
}
