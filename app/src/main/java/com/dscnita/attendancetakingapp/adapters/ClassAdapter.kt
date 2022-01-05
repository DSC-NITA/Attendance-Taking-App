package com.dscnita.attendancetakingapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dscnita.attendancetakingapp.R
import com.dscnita.attendancetakingapp.fragments.ClassFragmentDirections
import com.dscnita.attendancetakingapp.entities.ClassItem

class ClassAdapter(
    private val context: Context,
    private val dataset: MutableList<ClassItem>
) : RecyclerView.Adapter<ClassAdapter.ClassViewHolder> (){


    class ClassViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val className: TextView =view.findViewById(R.id.className)
        val subjectName: TextView =view.findViewById(R.id.subjectName)
        val button:Button=view.findViewById(R.id.takeAttendance)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.class_item, parent, false)

        return ClassViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        holder.className.text = dataset[position].className
        holder.subjectName.text = dataset[position].subjectName
        holder.button.setOnClickListener {
            val action= ClassFragmentDirections.actionClassFragmentToStudentFragment(className = dataset[position].className, subjectName = dataset[position].subjectName)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}