package com.example.a15_5_23_apiwithcoruting.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a15_5_23_apiwithcoruting.model.Users
import com.example.a15_5_23_apiwithcoruting.databinding.ItemShowdataBinding
import com.squareup.picasso.Picasso

class DataShowAdapter(var userList: ArrayList<Users>) : RecyclerView.Adapter<DataShowAdapter.InnerDataShowAdapter>() {


    inner class InnerDataShowAdapter(var view: ItemShowdataBinding) :
        RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerDataShowAdapter {
        return InnerDataShowAdapter(
            ItemShowdataBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    override fun onBindViewHolder(holder: InnerDataShowAdapter, position: Int) {
        userList[position].apply {
            Picasso.with(holder.itemView.context).load(avatarUrl).into(holder.view.imageView)//using picasso image fetch
        }
        holder.view.textView2.text = userList[position].id.toString()
        holder.view.textView3.text = userList[position].type.toString()
        holder.view.textView4.text = userList[position].followersUrl.toString()
    }
}