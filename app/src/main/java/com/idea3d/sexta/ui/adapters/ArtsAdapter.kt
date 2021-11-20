package com.idea3d.sexta.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idea3d.sexta.data.model.Art

import com.idea3d.sexta.databinding.ItemArtBinding


class ArtsAdapter(
    val arts: List<Art>,
    val checkArts: (Art) -> Unit,
    val deleteArts: (Art) -> Unit) : RecyclerView.Adapter<ArtsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemArtBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arts[position]
        holder.bind(item, checkArts, deleteArts)
    }

    override fun getItemCount(): Int {
        return arts.size
    }

    class ViewHolder(private val itemBinding: ItemArtBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val tvArt = itemBinding.tvArts
        val cbIsDone = itemBinding.cbIsDone


        fun bind(art: Art, checkArt: (Art) -> Unit, deleteArt: (Art) -> Unit) {
            tvArt.text = art.name
            cbIsDone.isChecked = art.isDone
            cbIsDone.setOnClickListener { checkArt(art) }
            itemView.setOnClickListener { deleteArt(art) }
        }
    }
}