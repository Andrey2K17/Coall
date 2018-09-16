package ag.pg13.coal.Adapter

import ag.pg13.coal.Model.Provider
import ag.pg13.coal.R
import ag.pg13.coal.R.layout.row_layout
import android.app.Activity
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.row_layout.view.*

class ListProviderAdapter(internal var activity: Activity, internal var lstProviders:List<Provider>,

                          internal var nameProvider:TextView) : BaseAdapter() {
//    private class ViewHolder (row: View?){
//        var idProvider: TextView? = null
//        var nameProvider: TextView? = null
//
//        init {
//            this.idProvider = row?.findViewById<TextView>(R.id.idProvider)
//            this.nameProvider = row?.findViewById<TextView>(R.id.nameProvider)
//        }
//    }

    internal var inflater: LayoutInflater

    init {
        inflater =activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView: View
        rowView = inflater.inflate(row_layout,null)

       rowView.nameProvider.text = lstProviders[position].name.toString()

        return rowView
    }

    override fun getItem(position: Int): Any {
        return lstProviders[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return lstProviders.size
    }
}