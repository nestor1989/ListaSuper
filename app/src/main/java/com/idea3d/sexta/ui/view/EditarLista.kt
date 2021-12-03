package com.idea3d.sexta.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.idea3d.sexta.R
import com.idea3d.sexta.data.model.DataSource
import com.idea3d.sexta.data.model.RepoImp
import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.databinding.FragmentEditarListaBinding
import com.idea3d.sexta.databinding.FragmentMainBinding
import com.idea3d.sexta.databinding.FragmentNuevaListaBinding
import com.idea3d.sexta.ui.adapters.TasksAdapter
import com.idea3d.sexta.ui.viewmodel.SharedViewModel
import com.idea3d.sexta.ui.viewmodel.VMFactory

class EditarLista : Fragment() {

    private var _binding: FragmentEditarListaBinding? = null
    private val binding get() = _binding!!
    lateinit var tasks: MutableList<Task>
    lateinit var adapter: TasksAdapter
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
        _binding = FragmentEditarListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.aniadirProductos)
        }

    }

}