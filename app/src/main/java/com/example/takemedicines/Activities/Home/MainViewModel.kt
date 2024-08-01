package com.example.takemedicines.Activities.Home

import android.text.SpannableString
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _styledText = MutableLiveData<SpannableString>()
    val styledText: LiveData<SpannableString> get() = _styledText



}