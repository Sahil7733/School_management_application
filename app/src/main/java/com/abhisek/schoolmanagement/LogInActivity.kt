package com.abhisek.schoolmanagement

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LogInActivity : AppCompatActivity(){



    lateinit var etMobileNumber: EditText
    lateinit var etPassWord: EditText
    lateinit var btLogIn: Button
    lateinit var txtRegister: TextView
    lateinit var txtForgotPassword: TextView

    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("Sahil", "Abhi","Raj", "Akash" )

    lateinit var sharedPreferences:  SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)
        enableEdgeToEdge()

        if (isLoggedIn){

            val intent = Intent(this@LogInActivity, DashBoardActivity::class.java)
            startActivity(intent)
            finish()

        }

        title = "Log In"

        etMobileNumber = findViewById(R.id.etmobilenumber)
        etPassWord = findViewById(R.id.etpw)
        btLogIn = findViewById(R.id.btnlogin)
        txtRegister = findViewById(R.id.txtregister)
        txtForgotPassword = findViewById(R.id.txtforgotpassword)


        btLogIn.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val Password = etPassWord.text.toString()

            var nameOfStudent = "Student"
            val intent = Intent(/* packageContext = */ this@LogInActivity, /* cls = */ DashBoardActivity::class.java)


            if ( (mobileNumber == validMobileNumber) ) {
                if(Password == validPassword[0]){

                    nameOfStudent = "Sahil"

                    savePreferences(nameOfStudent)

                    startActivity(intent)

                }else if(Password == validPassword[1]){

                    nameOfStudent ="Abhi"

                    savePreferences(nameOfStudent)

                    startActivity(intent)

                }else if (Password == validPassword[2]){

                    nameOfStudent ="Raj"

                    savePreferences(nameOfStudent)

                    startActivity(intent)

                }else if (Password == validPassword[3]){

                    nameOfStudent ="Akash"

                    savePreferences(nameOfStudent)

                    startActivity(intent)

                }
            } else {
                Toast.makeText(/* context = */ this@LogInActivity, /* text = */
                    "Incorrect Credential", /* duration = */
                    Toast.LENGTH_LONG).show()
            }

        }


    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String){
        sharedPreferences.edit().putBoolean("isLogged In", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }


}