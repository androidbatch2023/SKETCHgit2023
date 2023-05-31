package com.example.a15_5_23_apiwithcoruting.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.a10_5_23_apicalling.modelRequest.DataRequest
import com.example.a15_5_23_apiwithcoruting.ApiInterface
import com.example.a15_5_23_apiwithcoruting.RetrofitProvider
import com.example.a15_5_23_apiwithcoruting.databinding.FragmentTwoBinding
import com.example.a15_5_23_apiwithcoruting.modelRequest.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TwoFragment : Fragment() {

    private lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonPostData.setOnClickListener {
            val id = binding.editTextId.text.toString().toInt()
            val name = binding.editTextName.text.toString()
            val job = binding.editTextCname.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                val userData = DataRequest(Data(id,null,name,job,null))
                postData(userData)
            }
        }
        binding.buttonDeleteData.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                deleteData()
            }
        }
    }

    private suspend fun postData(users: DataRequest) {

        val retrofitInstance = RetrofitProvider.getInstance("https://reqres.in")
        val apiInterface = retrofitInstance?.create(ApiInterface::class.java)

        val user = apiInterface?.addUser(users)

        Log.d("TAG", "postData: ${user.toString()}")

        withContext(Dispatchers.Main) {
            binding.rvShowData.text = user.toString()
        }
    }

    private suspend fun deleteData() {

        val retrofitInterface = RetrofitProvider.getInstance("https://reqres.in")
        val apiInterface = retrofitInterface?.create(ApiInterface::class.java)

        val id = binding.editTextDeleteFeild.text.toString().toInt()
        val deleteData = apiInterface?.deleteUser(id)
        Log.d("TAG", "deleteData() ${deleteData?.data?.id} ,${deleteData?.data?.firstName}, ${deleteData?.data?.lastName}")
    }
}
