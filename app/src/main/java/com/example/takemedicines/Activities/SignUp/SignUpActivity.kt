package com.example.takemedicines.Activities.SignUp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.takemedicines.R
import com.example.takemedicines.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var signUpAdapter: SignUpAdapter
    private  val viewModel: SignUpViewModel by viewModels()
    private val selectedAvatar: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val textWatcher = object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                validateForm()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }



        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        viewModel.prepareImagesListData()


        setupRecyclerView()
        binding.signUpCancel.setOnClickListener{
            finish()
        }
        binding.name.addTextChangedListener(textWatcher)
        binding.gender.setOnCheckedChangeListener{ _,_ -> validateForm()}
        binding.Final.setOnClickListener{
            val name = binding.name.text.toString()
            val gender = when (binding.gender.checkedRadioButtonId){
                R.id.radioButtonMale -> "Male"
                R.id.radioButtonFemale -> "Female"
                else -> ""
            }
        }
        viewModel.user.observe(this,Observer {
            user ->
        })
    }
    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(
            this,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerView.layoutManager = layoutManager
        signUpAdapter = SignUpAdapter(this,avatars,{avatar ->
            selectedAvatar = avatar
            validateForm()
        },viewModel.imagesList)
        binding.recyclerView.adapter = signUpAdapter
    }
    private fun validateForm(){
        val name = binding.name.text.toString()
        val gender = when(binding.gender.checkedRadioButtonId){
            R.id.radioButtonFemale -> "Female"
            R.id.radioButtonMale ->"Male"
            else -> ""
        }
        binding.Final.isEnabled = viewModel.isFormValid(name,selectedAvatar?.toString() ?: "", gender)
    }
}