package ag.pg13.coal


import ag.pg13.coal.DBHelper.DBHelper
import ag.pg13.coal.Model.Mark
import ag.pg13.coal.Model.Provider
import ag.pg13.coal.R.layout.row_layout
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_layout.*


class MainActivity : AppCompatActivity() {

    private lateinit var db:DBHelper
    private var lstProviders:List<Provider> = ArrayList<Provider>()
    private var lstMarks:List<Mark> = ArrayList<Mark>()
    private lateinit var nameProvider :  Array<String>
    private lateinit var nameMark :  Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        providerButton.setOnClickListener{
            showProviderDialog()
        }

        markButton.setOnClickListener{
            showMarkDialog()
        }

    }

    fun showProviderDialog(){
        db = DBHelper(this)
        lstProviders = db.allProviders
        nameProvider = Array(lstProviders.size, {""})
        for(i in 0..(lstProviders.size - 1)){
            nameProvider[i] = lstProviders[i].name.toString()
        }
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(row_layout,null)
        val adapter = ArrayAdapter(this, row_layout,nameProvider)
        dialog.setAdapter(adapter, { dialogInterface: DialogInterface, position: Int -> })
        dialog.setSingleChoiceItems(nameProvider,-1){ dialogInterface: DialogInterface, position: Int ->
            providerName.text = nameProvider[position]
            dialogInterface.dismiss()
        }
        dialog.setView(dialogView)
        dialog.setTitle("Поставщик")
        dialog.create().show()
    }

    fun showMarkDialog(){
        db = DBHelper(this)
        lstMarks = db.allMarks
        nameMark = Array(lstMarks.size, {""})
        for(i in 0..(lstMarks.size - 1)){
            nameMark[i] = lstMarks[i].name.toString()
        }
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(row_layout,null)
        val adapter = ArrayAdapter(this, row_layout,nameMark)
        dialog.setAdapter(adapter, { dialogInterface: DialogInterface, position: Int -> })
        dialog.setSingleChoiceItems(nameMark,-1){ dialogInterface: DialogInterface, position: Int ->
            markName.text = nameMark[position]
            dialogInterface.dismiss()
        }
        dialog.setView(dialogView)
        dialog.setTitle("Поставщик")
        dialog.create().show()
    }

}
