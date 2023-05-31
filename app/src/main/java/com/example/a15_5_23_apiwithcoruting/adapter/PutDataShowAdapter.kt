package com.example.a15_5_23_apiwithcoruting.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a10_5_23_apicalling.modelRequest.DataResponse
import com.example.a15_5_23_apiwithcoruting.databinding.ItemShowdata2Binding

class PutDataShowAdapter(var data: ArrayList<DataResponse>?) :RecyclerView.Adapter<PutDataShowAdapter.InnerPutDataShowAdapter>() {

    inner class InnerPutDataShowAdapter(var view : ItemShowdata2Binding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerPutDataShowAdapter {
       return InnerPutDataShowAdapter(ItemShowdata2Binding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(holder: InnerPutDataShowAdapter, position: Int) {
        holder.view.textView2.text = data?.get(position)?.id
        holder.view.textView3.text = data?.get(position)?.name
        holder.view.textView4.text = data?.get(position)?.job
    }
}