package com.example.a15_5_23_apiwithcoruting

import com.example.a10_5_23_apicalling.modelRequest.DataRequest
import com.example.a10_5_23_apicalling.modelRequest.DataResponse
import com.example.a15_5_23_apiwithcoruting.model.Users
import retrofit2.http.*

interface ApiInterface {
    //format api in json

    //    https://jsonplaceholder.typicode.com/users
    @GET("users")//get using data get to api
    suspend fun getUser(): ArrayList<Users>//

    @GET("/api/users")
    suspend fun getUserCr(): ArrayList<DataResponse> //path use a end Point

    @POST("/api/users")//post using a data send a api
    suspend fun addUser(@Body userData: DataRequest): DataRequest// body use A Object Send Karneke liye

    @PUT("/api/users/{id}") //put data update a api
    suspend fun updateUser(
        @Path("id") userId: Int, @Body requestParams: DataRequest
    ): DataRequest

    @DELETE("/api/users/{id}")
    suspend fun deleteUser(@Path("id") userId:Int):DataRequest

}