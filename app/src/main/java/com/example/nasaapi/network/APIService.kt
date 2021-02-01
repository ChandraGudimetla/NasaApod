package com.example.nasaapi.network

import com.example.nasaapi.model.NasaTO
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("apod?api_key=WiClrgOSN4SAoPnzFpbpdeQtgoNxZrz0jxExBVpj")
    fun getNasaPicture(): Call<NasaTO>
}