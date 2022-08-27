package com.navneet.gameassets1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.navneet.gameassets1.viewModels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var viewModelVar: MainActivityViewModel
    private lateinit var recycler: RecyclerView
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recyclerView)

        viewModelVar = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModelVar.init()
        viewModelVar.getArmorList().observe(this) {
            recyclerAdapter.notifyDataSetChanged()
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerAdapter = RecyclerAdapter(viewModelVar.getArmorList().value!!)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager
        recycler.adapter = recyclerAdapter

    }
}
