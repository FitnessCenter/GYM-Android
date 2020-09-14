package com.dsm.gym.data.local.pref

interface SharedPrefStorage {
    fun saveToken(token: String, access: Boolean)
    fun getToken(isAccess: Boolean): String
    fun removeToken()
}