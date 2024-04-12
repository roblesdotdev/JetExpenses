package com.roblesdotdev.jetexpenses.preferences

import android.content.SharedPreferences

class AndroidPreferences(
    private val sharedPreferences: SharedPreferences,
) : Preferences {
    override suspend fun setBoolean(
        key: String,
        value: Boolean,
    ) {
        sharedPreferences
            .edit()
            .putBoolean(
                key,
                value,
            )
            .apply()
    }

    override suspend fun getBoolean(
        key: String,
        defaultValue: Boolean,
    ): Boolean {
        return if (sharedPreferences.contains(key)) {
            sharedPreferences.getBoolean(key, false)
        } else {
            defaultValue
        }
    }
}
