package com.example.a15_5_23_apiwithcoruting.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a15_5_23_apiwithcoruting.ApiInterface
import com.example.a15_5_23_apiwithcoruting.RetrofitProvider
import com.example.a15_5_23_apiwithcoruting.activity.MainActivity
import com.example.a15_5_23_apiwithcoruting.adapter.DataShowAdapter
import com.example.a15_5_23_apiwithcoruting.databinding.FragmentOneBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OneFragment : Fragment() {

    private lateinit var binding: FragmentOneBinding
    private lateinit var userAdapter: DataShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewShowDataApiGet.setOnClickListener {

            var name = "bargain    sutariya"
            name  = name.replace(" ","")
            println(name) //middle space remove

            lifecycleScope.launch(Dispatchers.IO) {
                val retrofitInstance = RetrofitProvider.getInstance("https://api.github.com/")
                val apiInterface = retrofitInstance?.create(ApiInterface::class.java)

                val userList = apiInterface?.getUser()
                Log.d("TAG", "onViewCreated()")

                if (userList != null) {
                    withContext(Dispatchers.Main) {
                        binding.rvApiDataShow.layoutManager =
                            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                        binding.rvApiDataShow.adapter = DataShowAdapter(userList)
                    }
                }
            }
        }
        binding.textViewShowDataApiGet2.setOnClickListener {
            (activity as MainActivity).loadFragment(TwoFragment(), false, true)
        }
        binding.textViewShowDataApiGet3.setOnClickListener {
            (activity as MainActivity).loadFragment(ThreeFragment(), false, true)
        }
    }
}


