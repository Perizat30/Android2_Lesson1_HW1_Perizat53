package com.example.android2_lesson1_hw1_perizat53.ui.home.new_task

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android2_lesson1_hw1_perizat53.App
import com.example.android2_lesson1_hw1_perizat53.databinding.FragmentNewTaskBinding
import com.example.android2_lesson1_hw1_perizat53.ui.home.TaskModel

class NewTaskFragment : Fragment() {

    private lateinit var binding: FragmentNewTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentNewTaskBinding.inflate(inflater,container,false)

        initViews()
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener{
            /*setFragmentResult("new_task", bundleOf(
                "title" to binding.etTitle.text.toString(),
                "desc" to binding.etDesc.text.toString()
            ))*/

            App.db.taskDao().insert(TaskModel(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesc.text.toString()
            ))

            Log.e("ololo","Заметка создана:"+ binding.etTitle.text.toString())
            findNavController().navigateUp()
        }
    }

    private fun initViews() {

    }
}