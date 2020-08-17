package com.dsm.gym.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SharedPrefStorageImpl(val context: Context) : SharedPrefStorage{
    override fun saveToken(token: String) {
        Log.d("saveToken",getToken())

        return getPref(context).edit().let {
            it.putString(getKey(), token)
            it.apply()
    }}

    override fun getToken(): String =
        "${getPref(context).getString(getKey(),"")}"

    override fun removeToken() =
        getPref(context).edit().let {
            it.remove(getKey())
            it.apply()
    }

    private fun getPref(context: Context): SharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

    private fun getKey(): String = "Access"
}