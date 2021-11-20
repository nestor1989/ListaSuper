package com.idea3d.sexta.ui.view




import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idea3d.sexta.R
import com.idea3d.sexta.core.TaskApp
import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.databinding.FragmentMainBinding
import com.idea3d.sexta.ui.adapters.TasksAdapter
import com.idea3d.sexta.ui.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.nio.channels.Selector

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    lateinit var recyclerView: RecyclerView
    lateinit var tasks: MutableList<Task>
    lateinit var adapter: TasksAdapter
    private lateinit var taskSelector: Selector
    private val model: SharedViewModel by activityViewModels()

    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tasks = ArrayList()
        getTasks()

        binding.btnAddTask.setOnClickListener {
            addTask(Task(name = etTask.text.toString()))
        }
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.nuevaLista)
        }

    }

    fun getTasks() {
        doAsync {
            tasks = TaskApp.database.taskDao().getAll()
            uiThread {
                setUpRecyclerView(tasks)
            }
        }
    }

    fun setUpRecyclerView(tasks: List<Task>) {
        val appContext = requireContext().applicationContext
        adapter = TasksAdapter(tasks, { updateTask(it) }, { deleteTask(it) })
        recyclerView = binding.rvTask
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(appContext)
        recyclerView.adapter = adapter
    }

    fun addTask(task: Task) {
        doAsync {
            val id = TaskApp.database.taskDao().addTask(task)
            val recoveryTask = TaskApp.database.taskDao().getById(id)
            uiThread {
                tasks.add(recoveryTask)
                adapter.notifyItemInserted(tasks.size)
                clearFocus()

            }
        }
    }

    fun clearFocus(){
        etTask.setText("")
    }


    fun updateTask(task: Task) {
        doAsync {
            task.isDone = !task.isDone
            TaskApp.database.taskDao().updateTask(task)
        }
    }

    fun deleteTask(task: Task){
        doAsync {
            val position = tasks.indexOf(task)
            TaskApp.database.taskDao().deleteTask(task)
            tasks.remove(task)
            uiThread {
                adapter.notifyItemRemoved(position)
            }
        }
    }
}