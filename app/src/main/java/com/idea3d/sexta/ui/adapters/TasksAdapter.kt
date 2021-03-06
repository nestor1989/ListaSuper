package com.idea3d.sexta.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.databinding.ItemTaskBinding

class TasksAdapter(
    private val itemClickListener:OnTaskClickListener,
    val tasks: List<Task>,
    val checkTask: (Task) -> Unit,
    val deleteTask: (Task) -> Unit) : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {



    interface OnTaskClickListener{
        fun onTaskClick(task:Task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
           ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = tasks[position]
        holder.bind(item, checkTask, deleteTask)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    inner class ViewHolder(private val itemBinding:ItemTaskBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val tvTask = itemBinding.tvTask
        val cbIsDone = itemBinding.cbIsDone
        //val binding = ItemTaskBinding.bind(view)

        fun bind(task: Task, checkTask: (Task) -> Unit, deleteTask: (Task) -> Unit) {
            tvTask.text = task.name
            cbIsDone.isChecked = task.isDone
            //cbIsDone.setOnClickListener { checkTask(task) }
            itemView.setOnClickListener { itemClickListener.onTaskClick(task) }
        }
    }

}



