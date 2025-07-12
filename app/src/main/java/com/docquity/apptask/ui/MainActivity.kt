package com.docquity.apptask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.docquity.apptask.adapter.ProcessAdapter
import com.docquity.apptask.adapter.TaskGroupAdapter
import com.docquity.apptask.databinding.ActivityMainBinding
import com.docquity.apptask.viewmodel.UserVM

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var userViewModel: UserVM? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this)[UserVM::class.java]

        userViewModel?.getUserInfo()
        userViewModel?.vmUser?.observe(this) {
            binding.tvUserName.text = it.user.name
        }

        binding.rvProcess.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvProcess.adapter = ProcessAdapter()

        binding.rvTaskGroup.layoutManager = LinearLayoutManager(this)
        binding.rvTaskGroup.adapter = TaskGroupAdapter()

    }
}