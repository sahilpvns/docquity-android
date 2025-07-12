package com.docquity.apptask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.docquity.apptask.adapter.ProcessAdapter
import com.docquity.apptask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProcess.layoutManager = LinearLayoutManager(this)
        binding.rvProcess.adapter = ProcessAdapter()

    }
}