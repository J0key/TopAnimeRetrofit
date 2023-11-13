package com.example.tugas9

import android.app.LauncherActivity
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.ModelLoader

class RickAdapter(private var dataRick: List<DataItem?>?): RecyclerView.Adapter<RickAdapter.MyViewHolder>() {

    class MyViewHolder (view: View): RecyclerView.ViewHolder(view){
        val imgRick = view.findViewById<ImageView>(R.id.item_image_Rick)
        val sourceRick = view.findViewById<TextView>(R.id.item_source_rick)
        val titleRick = view.findViewById<TextView>(R.id.item_title_rick)
        val statusRick = view.findViewById<TextView>(R.id.item_status_rick)
        val episodeRick = view.findViewById<TextView>(R.id.item_episode_rick)
        val durationRick = view.findViewById<TextView>(R.id.item_duration_rick)
        val ratingRick = view.findViewById<TextView>(R.id.item_rating_rick)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(dataRick != null){
            return this.dataRick!!.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.sourceRick.text = dataRick?.get(position)?.source
        holder.titleRick.text = dataRick?.get(position)?.title
        holder.statusRick.text = dataRick?.get(position)?.status
        holder.episodeRick.text = dataRick?.get(position)?.episodes.toString()
        holder.durationRick.text = dataRick?.get(position)?.duration
        holder.ratingRick.text = dataRick?.get(position)?.rating


        Glide.with(holder.imgRick)
            .load(dataRick?.get(position)?.images?.jpg?.imageUrl)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgRick)


        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("title", holder.titleRick.text)
            intent.putExtra("image", dataRick?.get(position)?.images?.jpg?.imageUrl)
            intent.putExtra("synopsis", dataRick?.get(position)?.synopsis)
            context.startActivity(intent)

            val name = dataRick?.get(position)?.title
            Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()


        }
    }

}