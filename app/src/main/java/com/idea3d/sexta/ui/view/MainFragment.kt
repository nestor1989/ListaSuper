package com.idea3d.sexta.ui.view




import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idea3d.sexta.R
import com.idea3d.sexta.core.TaskApp
import com.idea3d.sexta.data.model.DataSource
import com.idea3d.sexta.data.model.RepoImp
import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.databinding.FragmentMainBinding

import com.idea3d.sexta.ui.adapters.TasksAdapter
import com.idea3d.sexta.ui.viewmodel.SharedViewModel
import com.idea3d.sexta.ui.viewmodel.VMFactory

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    lateinit var recyclerView: RecyclerView
    lateinit var tasks: MutableList<Task>
    lateinit var adapter: TasksAdapter
    lateinit var task:Task

    private val viewModel by activityViewModels<SharedViewModel>{
        VMFactory(RepoImp(DataSource())) }



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

       viewModel.allTask.observe(this, Observer {
            // Update the cached copy of the words in the adapter.
            tasks?.let { adapter.submitList(it) }


        })





        /*binding.btnAddTask.setOnClickListener {
            viewModel.addTask()
        addTask(Task(name = etTask.text.toString()))
        }*/
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.nuevaLista)
        }

    }

    suspend fun getTasks() {
        //doAsync {
            tasks = TaskApp.database.taskDao().getAll()
            //uiThread {
        setUpRecyclerView(tasks)
            }
        //}
    //}

    fun setUpRecyclerView(tasks: MutableList<Task>) {
        val appContext = requireContext().applicationContext
        adapter = TasksAdapter(tasks, { viewModel.updateTask(it) }, { viewModel.deleteTask(it) })
        recyclerView = binding.rvTask
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(appContext)
        recyclerView.adapter = adapter
    }



    /*fun clearFocus(){
        binding.etTask.setText("")
    }*/



}