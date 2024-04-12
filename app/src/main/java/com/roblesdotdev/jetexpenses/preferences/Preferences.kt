package com.roblesdotdev.jetexpenses.preferences

interface Preferences {
    suspend fun setBoolean(
        key: String,
        value: Boolean,
    )

    suspend fun getBoolean(
        key: String,
        defaultValue: Boolean,
    ): Boolean
}
