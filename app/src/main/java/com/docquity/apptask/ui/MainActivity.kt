package com.docquity.apptask.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.docquity.apptask.adapter.ProcessAdapter
import com.docquity.apptask.adapter.TaskGroupAdapter
import com.docquity.apptask.databinding.ActivityMainBinding
import com.docquity.apptask.model.UserInfo
import com.docquity.apptask.viewmodel.UserVM

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val userVM: UserVM by lazy { ViewModelProvider(this)[UserVM::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setLayoutManager()
        setupProfile()
        setupProcess()
        setupTaskGroup()
        errorHandling()
    }

    private fun errorHandling() {
        userVM.vmError.observe(this) {
            if (it != null) {
                Toast.makeText(this, "Something went wrong $it", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setLayoutManager() {
        binding.rvProcess.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvTaskGroup.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun setupTaskGroup() {
        userVM.getTaskGroup()
        userVM.vmTaskGroup.observe(this) {
            if (it != null) {
                binding.tvTaskGroup.visibility = View.VISIBLE
                binding.rvTaskGroup.adapter = TaskGroupAdapter(it)
            } else {
                Toast.makeText(this, "Something went wrong $it", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupProcess() {
        userVM.getProcess()
        userVM.vmProcess.observe(this) {
            if (it != null) {
                binding.tvProcess.visibility = View.VISIBLE
                binding.rvProcess.adapter = ProcessAdapter(it)
            } else {
                Toast.makeText(this, "Something went wrong $it", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupProfile() {
        userVM.getUserInfo()
        userVM.vmUser.observe(this) {
            if (it != null) {
                setProfile(it)
            } else {
                Toast.makeText(this, "Something went wrong $it", Toast.LENGTH_LONG).show()
            }
        }
    }
}

private fun MainActivity.setProfile(it: UserInfo) {
    binding.apply {
        tvUserName.text = it.user.name
        tvUserDetail.text = it.user.greeting
        tvTaskStatus.text = it.user.completion_status
        btViewTask.text = it.user.action
        progressText.text = it.user.progress.toString() + "%"
        circularProgress.progress = it.user.progress
        Glide.with(this@setProfile).load(it.user.profile_url).into(binding.ivUserImage)
    }

}

