package com.example.takemedicines.Activities.SignUp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.takemedicines.Data.ImagesSignUp
import com.example.takemedicines.R
import com.example.takemedicines.databinding.ActivitySignUpBinding
import com.example.takemedicines.databinding.ItemImagesSignupBinding

class SignUpAdapter(
    private val avatars : List<Int>,
    private val onAvatarClick: (Int) -> Unit,
    private val items: List<ImagesSignUp>
): RecyclerView.Adapter<SignUpAdapter.SignUpViewHolder>() {

    private var selectedPosition = -1

   inner class SignUpViewHolder(private val binding: ItemImagesSignupBinding): RecyclerView.ViewHolder(binding.root) {

       fun bind(items: ImagesSignUp, position: Int) {
           binding.imageView.setImageResource(items.images)
           binding.root.isSelected = selectedPosition == position

           binding.root.setOnClickListener{
               val previousPosition = selectedPosition
               selectedPosition = position
               notifyItemChanged(previousPosition)
               notifyItemChanged(position)
               onAvatarClick(items.images)
           }
       }

   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): SignUpAdapter.SignUpViewHolder {
        val binding = ItemImagesSignupBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SignUpViewHolder(binding)

    }
    override fun onBindViewHolder(holder: SignUpViewHolder, position: Int) {
        holder.bind(items[position],position)
    }

    override fun getItemCount(): Int = items.size
}
