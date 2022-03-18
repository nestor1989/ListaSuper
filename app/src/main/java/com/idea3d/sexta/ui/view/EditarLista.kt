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
import com.idea3d.sexta.data.model.*
import com.idea3d.sexta.databinding.FragmentEditarListaBinding
import com.idea3d.sexta.databinding.FragmentMainBinding
import com.idea3d.sexta.databinding.FragmentNuevaListaBinding
import com.idea3d.sexta.ui.adapters.ArtsAdapter
import com.idea3d.sexta.ui.adapters.TasksAdapter
import com.idea3d.sexta.ui.viewmodel.SharedViewModel
import com.idea3d.sexta.ui.viewmodel.VMFactory
import com.idea3d.sexta.vo.Resource
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EditarLista : Fragment() {

    private var _binding: FragmentEditarListaBinding? = null
    private val binding get() = _binding!!
    lateinit var arts: List<Art>
    lateinit var adapter: ArtsAdapter
    private val viewModel by activityViewModels<SharedViewModel>{
        VMFactory(RepoImp(DataSource(TaskDb.getDataBase(requireActivity().applicationContext)))) }
    lateinit var recyclerView: RecyclerView

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

        arts = ArrayList()
        getArts()


        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.aniadirProductos)
        }

    }

    fun getArts() {
        viewModel.getArtByTaskId.observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Success->{ setUpRecyclerView(result.data)}
            }
        })
    }

    fun setUpRecyclerView(arts: List<Art>) {
        val appContext = requireContext().applicationContext
        adapter = ArtsAdapter(arts, { updateArt(it) }, { deleteArt(it) })
        recyclerView = binding.rvArt
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(appContext)
        recyclerView.adapter = adapter
    }


    fun updateArt(art: Art) {
        doAsync {
            art.isDone = !art.isDone
            viewModel.updateArt(art)
        }
    }

    fun deleteArt(art: Art){
        doAsync {
            val position = arts.indexOf(art)
            viewModel.deleteArt(art)
            //arts.remove(art)
            uiThread {
                adapter.notifyItemRemoved(position)
            }
        }
    }

}