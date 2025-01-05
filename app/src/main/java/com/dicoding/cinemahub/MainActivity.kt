package com.dicoding.cinemahub

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFilm: RecyclerView
    private val list = ArrayList<Film>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTitleBold)

        rvFilm = findViewById(R.id.rv_heroes)
        rvFilm.setHasFixedSize(true)

        list.addAll(getListFilm())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListFilm(): ArrayList<Film> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFilm = ArrayList<Film>()
        for (i in dataName.indices) {
            val film = Film(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFilm.add(film)
        }
        return listFilm
    }

    private fun showRecyclerList() {
        rvFilm.layoutManager = LinearLayoutManager(this)
        val listFilmAdapter = ListFilmAdapter(list)
        rvFilm.adapter = listFilmAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                // Navigate to ProfileActivity
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
