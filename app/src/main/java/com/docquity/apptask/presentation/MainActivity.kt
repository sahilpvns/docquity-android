package com.docquity.apptask.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.docquity.apptask.presentation.adapter.ProcessAdapter
import com.docquity.apptask.presentation.adapter.TaskGroupAdapter
import com.docquity.apptask.databinding.ActivityMainBinding
import com.docquity.apptask.domain.repository.model.UserInfo
import com.docquity.apptask.presentation.viewmodel.UserVM
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val userVM: UserVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        userVM.loadAllData()
        setLayoutManager()
        setupProfile()
        setupProcess()
        setupTaskGroup()
        errorHandling()
    }

    private fun errorHandling() {
        userVM.vmError.observe(this) {
            if (it != null) {
                Toast.makeText(this, "Something went wrong $it", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setLayoutManager() {
        binding.rvProcess.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvTaskGroup.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun setupTaskGroup() {
        userVM.vmTaskGroup.observe(this) {
            if (it != null) {
                binding.apply {
                    tvTaskGroup.visibility = View.VISIBLE
                    tvTaskGroupNumber.visibility = View.VISIBLE
                    tvTaskGroupNumber.text = it.size.toString()
                    rvTaskGroup.adapter = TaskGroupAdapter(it)
                }
            } else {
                Toast.makeText(this, "Something went wrong $it", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupProcess() {
        userVM.vmProcess.observe(this) {
            if (it != null) {
                binding.apply {
                    tvProcess.visibility = View.VISIBLE
                    tvProcessNumber.visibility = View.VISIBLE
                    tvProcessNumber.text = it.size.toString()
                    rvProcess.adapter = ProcessAdapter(it)
                }
            } else {
                Toast.makeText(this, "Something went wrong $it", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupProfile() {
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

