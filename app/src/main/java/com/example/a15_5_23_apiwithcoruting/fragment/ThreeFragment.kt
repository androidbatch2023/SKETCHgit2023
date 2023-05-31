package com.example.a15_5_23_apiwithcoruting.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a10_5_23_apicalling.modelRequest.DataRequest
import com.example.a15_5_23_apiwithcoruting.ApiInterface
import com.example.a15_5_23_apiwithcoruting.RetrofitProvider
import com.example.a15_5_23_apiwithcoruting.adapter.PutDataShowAdapter
import com.example.a15_5_23_apiwithcoruting.databinding.FragmentThreeBinding
import com.example.a15_5_23_apiwithcoruting.modelRequest.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ThreeFragment : Fragment() {
    private lateinit var binding: FragmentThreeBinding
    private lateinit var userAdapter: PutDataShowAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonPutData.setOnClickListener {

            val id = binding.editTextId.text.toString().toInt()
            val name = binding.editTextname.text.toString()
            val job = binding.editTextCname.text.toString()

            CoroutineScope(Dispatchers.IO).launch {

                updateData(id, DataRequest(Data(id,null,name,job,null)))


            }
//            lifecycleScope.launch(Dispatchers.IO) {
////                getApiUpdate()
//            }

        }
    }

    suspend fun updateData(id: Int, userData: DataRequest) {

        val retrofitInstance = RetrofitProvider.getInstance("https://reqres.in")
        val apiInterface = retrofitInstance?.create(ApiInterface::class.java)
        val data = apiInterface?.updateUser(id, userData)

//        Log.d("TAG", "updateData() called with: id = $id, userData = $userData")

        withContext(Dispatchers.Main) {
//            binding.rvShowData.text = data.toString()
            Log.d("TAG", "updateData:ID : ${data?.data?.id},Name : ${data?.data?.firstName},Job : ${data?.data?.lastName} ")
        }
    }

//    private suspend fun getApiUpdate() {
//
//        val retrofitInstance = RetrofitProvider.getInstance("https://reqres.in")
//        val apiInterface = retrofitInstance?.create(ApiInterface::class.java)
//
//        val data = apiInterface?.getUserCr()
//
//
//        withContext(Dispatchers.Main) {
//            binding.rvShowData.layoutManager =
//                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
//            binding.rvShowData.adapter = userAdapter
//            userAdapter = PutDataShowAdapter(data)
//
//        }
//    }
}