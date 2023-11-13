package com.example.tugas9

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.tugas9.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imgRick = findViewById<ImageView>(R.id.ivImage)
        val synopsis1 = intent.getStringExtra("synopsis")
        val anime = intent.getStringExtra("title")


        Glide.with(this)
            .load(intent.getStringExtra("image"))
            .error(R.drawable.ic_launcher_background)
            .into(imgRick)

        with(binding){
            tvSynopsis.text = synopsis1
            tvDetails.text = anime

            btnBack.setOnClickListener{
                val intent = Intent(this@DetailsActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}