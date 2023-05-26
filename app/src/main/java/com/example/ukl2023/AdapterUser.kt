package com.example.ukl2023
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ukl2023.databinding.DatauserBinding

import java.util.*

class AdapterUser(private val context: Context, private val user : ArrayList<User>, private val userViewModel: UserViewModel): RecyclerView.Adapter<AdapterUser.ViewHolder>() {
    inner class ViewHolder(private val binding : DatauserBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.cardUserTvTitle.text = user.username
            binding.cardUserTvDesc.text = user.job
            when(user.image){
                1 -> binding.cardUserIvImage.setImageResource(R.drawable.victim)

                2 -> binding.cardUserIvImage.setImageResource(R.drawable.beetle)

                3 -> binding.cardUserIvImage.setImageResource(R.drawable.gosling)

                else -> binding.cardUserIvImage.setImageResource(R.drawable.tanbo)
            }
            binding.cardUserIvDelete.setOnClickListener {
                userViewModel.deleteUser(user)
            }
        }
        fun onClick(context: Context, user: User){
            binding.cardUserIvUpdate.setOnClickListener {
                val intent = Intent(context, UpdateUser::class.java)
                intent.putExtra("id", user.id)
                intent.putExtra("name", user.name)
                intent.putExtra("userName", user.username)
                intent.putExtra("password", user.password)
                intent.putExtra("jobdesc", user.job)
                context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterUser.ViewHolder {
        val binding = DatauserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(user[position])
        holder.onClick(context = context, user[position])

    }

    override fun getItemCount(): Int {
        return user.size
    }

    fun updateFood(newList: List<User>){
        user.clear()
        user.addAll(newList)
        notifyDataSetChanged()
    }

}
