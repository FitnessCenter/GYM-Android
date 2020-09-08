package com.dsm.gym.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SharedPrefStorageImpl(val context: Context) : SharedPrefStorage {
    override fun saveToken(token: String, access: Boolean) {
        Log.d("saveToken", getToken(access))

        return getPref(context).edit().let {
            it.putString(getKey(access), token)
            it.apply()
        }
    }

    override fun getToken(isAccess: Boolean): String {
        return if(getPref(context).getString(getKey(isAccess),"")!!.isNotBlank()){
            "Bearer ${getPref(context).getString(getKey(isAccess), "")}"
        } else ""
    }

    override fun removeToken() =
        getPref(context).edit().let {
            it.remove(getKey(true))
            it.apply()
        }

    private fun getPref(context: Context): SharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

    private fun getKey(isAccess: Boolean): String = if (isAccess) "Access" else "Refresh"

}