package com.example.android2_lesson1_hw1_perizat53.ui.home.new_task

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android2_lesson1_hw1_perizat53.App
import com.example.android2_lesson1_hw1_perizat53.databinding.FragmentNewTaskBinding
import com.example.android2_lesson1_hw1_perizat53.ui.home.HomeFragment.Companion.EDIT_KEY
import com.example.android2_lesson1_hw1_perizat53.ui.home.TaskModel

class NewTaskFragment : Fragment() {

    private lateinit var binding: FragmentNewTaskBinding
    private lateinit var task: TaskModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewTaskBinding.inflate(inflater, container, false)

        initViews()
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener {
            if(arguments!=null){
                updateData(task)
            }else{
                saveData()
            }
            findNavController().navigateUp()
        }
    }

    private fun initViews() {
        if(arguments!=null){
            binding.btnSave.text="Update"
            task= arguments?.getSerializable(EDIT_KEY) as TaskModel
            binding.etTitle.setText(task.title)
            binding.etDesc.setText(task.desc)
        }else{
           binding.btnSave.text="Save"
        }
    }

    private fun saveData(){
        App.db.taskDao().insert(
            TaskModel(
            title = binding.etTitle.text.toString(),
            desc = binding.etDesc.text.toString()
        ))

        Log.e("ololo","Заметка создана:"+binding.etTitle.text.toString())
    }

    private fun updateData(taskModel: TaskModel){
        taskModel.title=binding.etTitle.text.toString()
        taskModel.desc=binding.etDesc.text.toString()

        App.db.taskDao().update(taskModel)
    }
}

