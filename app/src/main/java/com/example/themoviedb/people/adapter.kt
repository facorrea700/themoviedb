package com.example.themoviedb.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviedb.R

class AdapterPeople (var list: AbstractList<People>):RecyclerView.Adapter<AdapterPeople.ViewHolder>(){
    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        fun bindItems(data:People){
            val name:TextView=itemView.findViewById(R.id.textViewPeopleName)
            val description:TextView=itemView.findViewById(R.id.textViewDescriptionPeople)
            val image: ImageView =itemView.findViewById(R.id.imageMovie)

            name.text=data.name
            description.text=data.Description
            Glide.with(itemView.context).load(data.image).into(image)

            itemView.setOnClickListener{
                Toast.makeText(itemView.context, "Viendo info de: ${data.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent?.context).inflate(R.layout.content_item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdapterPeople.ViewHolder, position: Int) {
holder.bindItems(list[position])    }

    override fun getItemCount(): Int {
       return list.size
    }

}