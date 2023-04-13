package com.example.android2_lesson1_hw1_perizat53.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android2_lesson1_hw1_perizat53.App
import com.example.android2_lesson1_hw1_perizat53.R
import com.example.android2_lesson1_hw1_perizat53.databinding.FragmentHomeBinding
import com.example.android2_lesson1_hw1_perizat53.ui.home.new_task.TaskAdapter

@Suppress("UNCHECKED_CAST")
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)
        initViews()
        initListeners()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        taskAdapter=TaskAdapter(this::onClick,this::onLongClickListener)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.sort){
            val items = arrayOf("Date", "Alphabet A-z", "Alphabet z-A")
            val builder=AlertDialog.Builder(requireContext())
            with (builder){
                setTitle("Sort by...:")
                setItems(items){_, which ->
                    when(which){
                        0->{
                            taskAdapter.addAllTask(App.db.taskDao().getAllTasksByDate() as List<TaskModel>)
                        }
                        1->{
                            taskAdapter.addAllTask(App.db.taskDao().getAllTasksByAsc() as List<TaskModel>)
                        }
                        2->{
                            taskAdapter.addAllTask(App.db.taskDao().getAllTasksByDesc() as List<TaskModel>)
                        }
                    }
                }
                show()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun initListeners() {
        binding.fabHome.setOnClickListener {
            findNavController().navigate(R.id.newTaskFragment)
        }
    }

    private fun initViews() {

        binding.rvHome.layoutManager=LinearLayoutManager(context)
        binding.rvHome.adapter=taskAdapter
        getData()
    }

    private fun getData(){
        taskAdapter.addAllTask(App.db.taskDao().getAllTasksByDate() as List<TaskModel>)
    }

    private fun onClick(pos: Int) {
        val task=taskAdapter.getTask(pos)
        findNavController().navigate(R.id.newTaskFragment, bundleOf(EDIT_KEY to task))
    }

    private fun onLongClickListener(pos:Int){

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Deleting...")
        builder.setMessage("Do you want to delete "+taskAdapter.getTask(pos).title)

        builder.setPositiveButton(android.R.string.yes) { _, _ ->
            App.db.taskDao().delete(taskAdapter.getTask(pos))
            getData()
        }

        builder.setNegativeButton(android.R.string.no) { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }
    companion object{
        const val EDIT_KEY="EDIT"
    }
}

