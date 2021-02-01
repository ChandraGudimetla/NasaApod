package com.example.nasaapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasaapi.R
import com.example.nasaapi.model.NasaTO
import com.example.nasaapi.network.APIService
import com.example.nasaapi.network.RequestProvider
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var mApiService: APIService? = null
    private var mAdapter: ListAdapter? = null
    private var mData: List<NasaTO> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApiService = RequestProvider.client.create(APIService::class.java)
        recycler_view.layoutManager = LinearLayoutManager(this)
        fetchNasaImage()
    }

    fun fetchNasaImage() {
        val call = mApiService!!.getNasaPicture()
        call.enqueue(object : retrofit2.Callback<NasaTO> {
            override fun onResponse(call: Call<NasaTO>, response: Response<NasaTO>) {
                var mPicData = response.body()
                if (mPicData != null) {
                    mData = listOf(mPicData)
                    mAdapter = ListAdapter(mData)
                    recycler_view.adapter = mAdapter
                    mAdapter?.notifyDataSetChanged()

                }

            }

            override fun onFailure(call: Call<NasaTO>, t: Throwable) {
                Log.e("MainActivity", "Got error" + t.localizedMessage)
            }

        })

    }

}