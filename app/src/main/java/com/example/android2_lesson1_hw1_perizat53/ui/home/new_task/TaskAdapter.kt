package com.example.android2_lesson1_hw1_perizat53.ui.home.new_task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android2_lesson1_hw1_perizat53.databinding.TaskItemBinding
import com.example.android2_lesson1_hw1_perizat53.ui.home.TaskModel

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var taskList= arrayListOf<TaskModel>()

    fun addTask(taskModel: TaskModel){
        taskList.add(taskModel)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            TaskItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int {
        return taskList.size
    }


    class TaskViewHolder(private var binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(taskModel: TaskModel) {
            binding.itemTitle.text=taskModel.title
            binding.itemDesc.text=taskModel.desc

        }
    }
}