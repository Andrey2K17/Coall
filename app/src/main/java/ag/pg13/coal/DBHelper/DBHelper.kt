package ag.pg13.coal.DBHelper

import ag.pg13.coal.Model.Mark
import ag.pg13.coal.Model.Provider
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.util.Log
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper


class DBHelper(context: Context): SQLiteAssetHelper(context, DB_NAME, null, DB_VER) {

    companion object {
        private val DB_NAME="coal.db"
        private val DB_VER=1

        private val TBL_NAME="provider"
        private val COL_ID="_id"
        private val COL_NAME="name"

        private val TBL_MARK="mark"
        private val COL_MARK_ID="_id"
        private val COL_MARK_NAME="mark_name"
    }

    //CRUD

    val allProviders:List<Provider>
    get() {
        val lstProviders = ArrayList<Provider>()
        val selectQuery = "SELECT * FROM $TBL_NAME"
        val db=this.writableDatabase
        val cursor=db.rawQuery(selectQuery,null)

        if(cursor.moveToFirst())
        {
            do{
                val provider = Provider()
                provider.name=cursor.getString(cursor.getColumnIndex(COL_NAME))
                lstProviders.add(provider)
            }while (cursor.moveToNext())
        }
        db.close()
        return lstProviders
    }

    val allMarks:List<Mark>
    get() {
        val lstMarks = ArrayList<Mark>()
        val selectQuery = "SELECT * FROM $TBL_MARK"
        val db=this.writableDatabase
        val cursor=db.rawQuery(selectQuery,null)

        if(cursor.moveToFirst())
        {
            do{
                val mark = Mark()
                mark.name=cursor.getString(cursor.getColumnIndex(COL_MARK_NAME))
                lstMarks.add(mark)
            }while (cursor.moveToNext())
        }
        db.close()
        return lstMarks
    }





}