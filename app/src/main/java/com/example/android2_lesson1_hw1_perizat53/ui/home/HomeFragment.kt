package com.example.android2_lesson1_hw1_perizat53.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android2_lesson1_hw1_perizat53.R
import com.example.android2_lesson1_hw1_perizat53.databinding.FragmentHomeBinding
import com.example.android2_lesson1_hw1_perizat53.ui.home.new_task.TaskAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initViews()
        initListeners()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskAdapter=TaskAdapter()
    }

    private fun initListeners() {
        binding.fabHome.setOnClickListener {
            findNavController().navigate(R.id.newTaskFragment)
        }
    }

    private fun initViews() {

        binding.rvHome.layoutManager=LinearLayoutManager(context)
        binding.rvHome.adapter=taskAdapter

        setFragmentResultListener("new_task") { _, bundle ->
            Log.e(
                "ololo", "initViews: " + bundle.getString("title") +
                        bundle.getString("desc")
            )

            val title= bundle.getString("title")
            val desc= bundle.getString("desc")
            taskAdapter.addTask(TaskModel(
                title.toString(),desc.toString()
            ))


        }
    }
}

