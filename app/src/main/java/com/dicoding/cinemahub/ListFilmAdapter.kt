package com.dicoding.cinemahub

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListFilmAdapter(private val ListFilm: ArrayList<Film>) : RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val btnMoreInfo: Button = itemView.findViewById(R.id.btn_more_info)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_film, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = ListFilm.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = ListFilm[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.btnMoreInfo.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_NAME, name)
                putExtra(DetailActivity.EXTRA_DESCRIPTION, description)
                putExtra(DetailActivity.EXTRA_SINOPSIS, holder.itemView.context.resources.getStringArray(R.array.data_sinopsis)[position])
                putExtra(DetailActivity.EXTRA_RATING, holder.itemView.context.resources.getStringArray(R.array.data_rating)[position])
                putExtra(DetailActivity.EXTRA_GENRE, holder.itemView.context.resources.getStringArray(R.array.data_genre)[position])
                putExtra(DetailActivity.EXTRA_PHOTO, photo)
            }
            holder.itemView.context.startActivity(intent)
        }
    }
}
