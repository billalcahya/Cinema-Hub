package com.dicoding.cinemahub

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_SINOPSIS = "extra_sinopsis"
        const val EXTRA_RATING = "extra_rating"
        const val EXTRA_GENRE = "extra_genre"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.setStatusBarColor(resources.getColor(android.R.color.white))
            window.decorView.systemUiVisibility = WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
        }

        val tvName: TextView = findViewById(R.id.tv_name)
        val ivPhoto: ImageView = findViewById(R.id.iv_photo)
        val tvSinopsis : TextView = findViewById((R.id.tv_synopsis))
        val tvRating : TextView = findViewById(R.id.data_rating)
        val tvGenre : TextView = findViewById(R.id.data_genre)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, -1)
        val sinopsis = intent.getStringExtra((EXTRA_SINOPSIS))
        val rating = intent.getStringExtra(EXTRA_RATING)
        val genre = intent.getStringExtra(EXTRA_GENRE)

        tvName.text = name
        ivPhoto.setImageResource(photo)
        tvSinopsis.text = sinopsis
        tvRating.text = rating
        tvGenre.text = genre
    }
}
