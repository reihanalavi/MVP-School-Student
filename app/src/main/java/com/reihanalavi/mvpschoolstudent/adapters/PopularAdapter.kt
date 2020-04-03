package com.reihanalavi.mvpschoolstudent.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reihanalavi.mvpschoolstudent.R
import com.reihanalavi.mvpschoolstudent.models.Popular
import kotlinx.android.synthetic.main.items_student.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class PopularAdapter(val context: Context, val listener: (Popular) -> Unit) :
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    var popular: MutableList<Popular> = mutableListOf()

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {

        @SuppressLint("SetTextI18n")
        fun bindData(data: Popular, listener: (Popular) -> Unit) {

            itemView.items_student_nama.text = data.title
            itemView.items_student_nis.text = data.release
            itemView.items_student_kelamin.text = data.id

            itemView.onClick {
                listener(data)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.items_student, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = popular.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(popular[position], listener)
    }
}