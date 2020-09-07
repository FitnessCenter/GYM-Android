package com.dsm.gym.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SharedPrefStorageImpl(val context: Context) : SharedPrefStorage {
    override fun saveToken(token: String) {
        Log.d("saveToken", getToken())

        return getAuthPref(context).edit().let {
            it.putString(getAuthKey(), token)
            it.apply()
        }
    }

    override fun getToken(): String {
        return if(getAuthPref(context).getString(getAuthKey(),"")!!.isNotBlank()){
            "Bearer ${getAuthPref(context).getString(getAuthKey(), "")}"
        } else ""
    }


    override fun removeToken() =
        getAuthPref(context).edit().let {
            it.remove(getAuthKey())
            it.apply()
        }

    override fun saveSex(sex: Boolean) {
        return getSexPref(context).edit().let {
            it.putBoolean(getSexKey(), sex)
            it.apply()
        }
    }

    override fun getSex(): Boolean =
        getSexPref(context).getBoolean(getSexKey(), true)

    override fun removeSex() {
        getSexPref(context).edit().let {
            it.remove(getSexKey())
            it.apply()
        }
    }

    private fun getAuthPref(context: Context): SharedPreferences =
        context.getSharedPreferences("AuthPref", Context.MODE_PRIVATE)

    private fun getSexPref(context: Context): SharedPreferences =
        context.getSharedPreferences("SexPref", Context.MODE_PRIVATE)

    private fun getAuthKey(): String = "Access"

    private fun getSexKey(): String = "Sex"
}