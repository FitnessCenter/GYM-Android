package com.dsm.gym.data.local.pref

interface SharedPrefStorage {
    fun saveToken(token: String)
    fun getToken(): String
    fun removeToken()
}