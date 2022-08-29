package com.navneet.gameassets1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
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
    private lateinit var mProgressBar : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filterTextView : EditText= findViewById(R.id.filter_text_view)
         mProgressBar  = findViewById(R.id.progressBar)


        recycler = findViewById(R.id.recyclerView)
        viewModelVar = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModelVar.init()

        viewModelVar.getArmorList().observe(this) {
            if (viewModelVar.getArmorList().value!!.isNotEmpty()) {
//              Passing the updated ArmorList to fuction refreshRecycler of RecyclerAdapter, to replace data with new updated list from server
                recyclerAdapter.refreshRecycler(viewModelVar.getArmorList().value as ArrayList<Armor>)
                hideProgressBar()
            }
        }

//        implementing filter by input in EditText
        filterTextView.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                recyclerAdapter.filterRecycler(p0.toString())
            }

        } )

        initRecyclerView()
        mProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        mProgressBar.visibility = View.INVISIBLE

    }

    private fun initRecyclerView() {
        recyclerAdapter = RecyclerAdapter(viewModelVar.getArmorList().value!! as ArrayList<Armor>)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager
        recycler.adapter = recyclerAdapter

    }
}
