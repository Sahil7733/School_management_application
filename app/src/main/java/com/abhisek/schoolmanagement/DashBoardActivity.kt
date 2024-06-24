package com.abhisek.schoolmanagement

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity


class DashBoardActivity : ComponentActivity() {

    var titleName: String? = "Student"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_dash_board)

        titleName = sharedPreferences.getString("Title", "Student")
        title = titleName

    }
}