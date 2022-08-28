package com.navneet.gameassets1

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.navneet.gameassets1.models.Armor
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
            if (viewModelVar.getArmorList().value!!.size > 0) {
                recyclerAdapter.refreshRecycler(viewModelVar.getArmorList().value as ArrayList<Armor>)
            }
        }

//        implementing filter by input in EditText
        val filterTextView : EditText= findViewById(R.id.filter_text_view)
        filterTextView.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {

                recyclerAdapter.filerRecyler(p0.toString())
            }

        } )

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerAdapter = RecyclerAdapter(viewModelVar.getArmorList().value!! as ArrayList<Armor>)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager
        recycler.adapter = recyclerAdapter

    }
}
