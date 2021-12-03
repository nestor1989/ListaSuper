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
import com.idea3d.sexta.data.model.Art
import com.idea3d.sexta.data.model.DataSource
import com.idea3d.sexta.data.model.RepoImp

import com.idea3d.sexta.databinding.FragmentAniadirProductosBinding

import com.idea3d.sexta.ui.adapters.ArtsAdapter

import com.idea3d.sexta.ui.viewmodel.SharedViewModel
import com.idea3d.sexta.ui.viewmodel.VMFactory

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class AniadirProductos : Fragment() {

    private var _binding: FragmentAniadirProductosBinding? = null
    private val binding get() = _binding!!
    lateinit var recyclerView: RecyclerView
    lateinit var arts: MutableList<Art>
    lateinit var adapter: ArtsAdapter
    private val viewModel by activityViewModels<SharedViewModel> {
        VMFactory(RepoImp(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAniadirProductosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arts = ArrayList()
        getArts()

        binding.btnAddArt.setOnClickListener {
            addArt(Art(name = binding.etArt.text.toString()))
        }

        binding.botonHecho.setOnClickListener {
            findNavController().navigate(R.id.editarLista)
        }

    }

    fun getArts() {
        doAsync {
            arts = TaskApp.database.taskDao().getAllArt()
            uiThread {
                setUpRecyclerView(arts)
            }
        }
    }

    fun setUpRecyclerView(arts: List<Art>) {
        val appContext = requireContext().applicationContext
        adapter = ArtsAdapter(arts, { updateArt(it) }, { deleteArt(it) })
        recyclerView = binding.rvArt
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(appContext)
        recyclerView.adapter = adapter
    }

    fun addArt(art: Art) {
        doAsync {
            val id = TaskApp.database.taskDao().addArt(art)
            val recoveryArt = TaskApp.database.taskDao().getArtById(id)
            uiThread {
                arts.add(recoveryArt)
                adapter.notifyItemInserted(arts.size)
                clearFocus()

            }
        }
    }

    fun clearFocus(){
        binding.etArt.setText("")
    }


    fun updateArt(art: Art) {
        doAsync {
            art.isDone = !art.isDone
            TaskApp.database.taskDao().updateArt(art)
        }
    }

    fun deleteArt(art: Art){
        doAsync {
            val position = arts.indexOf(art)
            TaskApp.database.taskDao().deleteArt(art)
            arts.remove(art)
            uiThread {
                adapter.notifyItemRemoved(position)
            }
        }
    }
}