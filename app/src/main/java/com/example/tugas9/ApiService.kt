package com.example.tugas9

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET ("anime")

    fun getRick(): Call<ResponseRick>
}