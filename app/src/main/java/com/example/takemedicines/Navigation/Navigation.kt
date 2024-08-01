package com.example.takemedicines.Navigation

import android.content.Context
import android.content.Intent
import com.example.takemedicines.Activities.SignUp.SignUpActivity

class Navigation(private val context: Context) {

    fun navigateToSignUp(){
        val intent = Intent(context,SignUpActivity::class.java)
        context.startActivity(intent)
        }
}