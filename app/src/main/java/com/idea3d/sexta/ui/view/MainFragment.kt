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
import com.idea3d.sexta.vo.Resource

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    lateinit var recyclerView: RecyclerView
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

        viewModel.getAllTask().observe(viewLifecycleOwner, Observer{
            when(it){
                is Resource.Loading->{}
                is Resource.Success->{
                    setUpRecyclerView(it.data)
                }
                is Resource.Failure->{

                }
            }
        }
        )

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.nuevaLista)
        }

    }

    fun setUpRecyclerView(tasks: List<Task>) {
        val appContext = requireContext().applicationContext
        adapter = TasksAdapter(tasks, { viewModel.updateTask(it) }, { viewModel.deleteTask(it) })
        recyclerView = binding.rvTask
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(appContext)
        recyclerView.adapter = adapter
    }

}