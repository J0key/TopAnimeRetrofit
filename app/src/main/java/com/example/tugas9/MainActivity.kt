package com.example.tugas9

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas9.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyler:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        supportActionBar?.setCustomView(R.layout.actionbar_layout);
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#1e2025")));

        val rick = findViewById<RecyclerView>(R.id.rv_character)
        with(binding){
            ApiConfig.getService().getRick().enqueue(object : Callback<ResponseRick>{
                override fun onResponse(call: Call<ResponseRick>, response: Response<ResponseRick>){
                    if (response.isSuccessful){
                        val responseRick = response.body()
                        val dataRick = responseRick?.data
                        recyler=rvCharacter
                        val adapter = RickAdapter(dataRick)
                        recyler.adapter = adapter


                    }
                }
                override fun onFailure(call: Call<ResponseRick>, t: Throwable){
                    Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })
        }

    }
}