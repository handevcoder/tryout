package com.example.apptryout

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class LocalStorage(private val context: Context) {
    companion object {
        private const val NAME = "com.example.apptryout"
        private const val KEY_NAME = "KEY_NAME"
        private const val KEY_PASSWORD = "KEY_PASSWORD"
        private const val KEY_TOKEN = "KEY_TOKEN"
    }

    private val sharedPreferences by lazy {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    }
    private inline fun <reified T> SharedPreferences.save(key: String, value: T) {
        edit {
            when (value) {
                is Int -> putInt(key, value)
                is String -> putString(key, value)
                is Float -> putFloat(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Set<*> -> putStringSet(key, value as? Set<String> ?: setOf())
            }
        }
    }


    fun setPassword(data: Set<String>) {
        sharedPreferences.save(KEY_PASSWORD, data)
    }

    fun getPassword(): Set<String> {
        return sharedPreferences.getStringSet(KEY_PASSWORD, setOf()) ?: setOf()
    }

    fun setToken(data: Set<String>) {
        sharedPreferences.save(KEY_TOKEN, data)
    }

    fun getToken(): Set<String> {
        return sharedPreferences.getStringSet(KEY_TOKEN, setOf()) ?: setOf()
    }

    fun setUser(data: Set<String>) {
        sharedPreferences.save(KEY_NAME, data)
    }

    fun addUser(data: String) {
        val user = getUser().toMutableList().apply { add(data) }.toSet()
        sharedPreferences.save(KEY_NAME, user)
    }

    fun getUser(): Set<String> {
        return sharedPreferences.getStringSet(KEY_NAME, setOf()) ?: setOf()
    }


}