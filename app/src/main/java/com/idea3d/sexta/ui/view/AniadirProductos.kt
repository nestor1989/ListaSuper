package com.idea3d.sexta.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.idea3d.sexta.R
import com.idea3d.sexta.databinding.FragmentAniadirProductosBinding
import com.idea3d.sexta.databinding.FragmentEditarListaBinding
import com.idea3d.sexta.databinding.FragmentNuevaListaBinding


class AniadirProductos : Fragment() {

    private var _binding: FragmentAniadirProductosBinding? = null
    private val binding get() = _binding!!

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

        binding.botonHecho.setOnClickListener {
            findNavController().navigate(R.id.editarLista)
        }

    }
}