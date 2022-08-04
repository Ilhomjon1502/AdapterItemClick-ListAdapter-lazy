package com.conamobile.adapteritemclick

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.conamobile.adapteritemclick.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { TestAdapter() }
    private var list = ArrayList<TestModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapter()
        adapterList()
        adapterClick()
    }

    private fun adapterClick() {
        adapter.itemCLick = {
            Toast.makeText(this, "Click: ${it.text}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun adapterList() {
        for (i in 0..20)
            list.add(TestModel("Text: $i"))
    }

    private fun setupAdapter() {
        binding.recyclerView.adapter = adapter
        adapter.submitList(list)
    }
}