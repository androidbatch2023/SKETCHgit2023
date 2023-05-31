package com.example.a15_5_23_apiwithcoruting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a10_5_23_apicalling.modelRequest.DataResponse
import com.example.a15_5_23_apiwithcoruting.databinding.ItemShowdata2Binding

class UpdateDataShowAdapter(var userList: ArrayList<DataResponse?>) :
    RecyclerView.Adapter<UpdateDataShowAdapter.InnerUpdateDataShowAdapter>() {

//    private var userList = ArrayList<DataResponse?>()
//
//    fun getData(list: List<DataResponse?>) {
//        this.userList.addAll(list)
//    }


    inner class InnerUpdateDataShowAdapter(var view: ItemShowdata2Binding) :
        RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerUpdateDataShowAdapter {
        return InnerUpdateDataShowAdapter(
            ItemShowdata2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: InnerUpdateDataShowAdapter, position: Int) {
        holder.view.textView1.text = userList[position]?.id
        holder.view.textView2.text = userList[position]?.name
        holder.view.textView3.text = userList[position]?.job
    }
}