package com.idea3d.sexta.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.idea3d.sexta.R
import com.idea3d.sexta.data.model.*
import com.idea3d.sexta.databinding.FragmentMainBinding
import com.idea3d.sexta.databinding.FragmentNuevaListaBinding
import com.idea3d.sexta.ui.adapters.ArtsAdapter
import com.idea3d.sexta.ui.adapters.TasksAdapter
import com.idea3d.sexta.ui.viewmodel.SharedViewModel
import com.idea3d.sexta.ui.viewmodel.VMFactory
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_nueva_lista.*
import org.jetbrains.anko.doAsync

class NuevaLista : Fragment() {

    private var _binding: FragmentNuevaListaBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<SharedViewModel>{
        VMFactory(RepoImp(DataSource(TaskDb.getDataBase(requireActivity().applicationContext)))) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNuevaListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonCrear.setOnClickListener {
            val task=Task(name = etTask.text.toString())
            viewModel.addTask(task)
            viewModel.onTask(task)
            findNavController().navigate(R.id.editarLista)
        }

    }

}