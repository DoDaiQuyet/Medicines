package com.example.takemedicines.Activities.SignUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.takemedicines.Data.ImagesSignUp
import com.example.takemedicines.Data.User
import com.example.takemedicines.R

class SignUpViewModel: ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    val imagesList = mutableListOf<ImagesSignUp>()
    fun prepareImagesListData(){
        val images = listOf(
            ImagesSignUp(R.drawable.image),
            ImagesSignUp(R.drawable.image_1),
            ImagesSignUp(R.drawable.image_2),
            ImagesSignUp(R.drawable.image_3)
        )
        imagesList.addAll(images)
    }
    fun setUser(name: String,gender: String,avatar:String){
        _user.value = User(name,gender,avatar)
    }
    fun isFormValid(name: String,avatar: String,gender: String): Boolean{
        return name.isNotEmpty() && avatar.isNotEmpty() && gender.isNotEmpty()
    }
}