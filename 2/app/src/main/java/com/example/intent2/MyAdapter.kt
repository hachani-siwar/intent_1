package com.example.intent2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val values: ArrayList<ItemsViewModel>,
    private val listener: OnItemClickListener):
    RecyclerView.Adapter<MyAdapter.ViewHolder>()
{


    override fun onCreateViewHolder(parent:ViewGroup,viewType : Int):ViewHolder {
             val vh = LayoutInflater.from(parent.context).inflate(R.layout.recyleviewmodel,parent,false)
             return ViewHolder(vh)
         }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.textTitle.text=values[position].text
        holder.image.setImageResource(values[position].image)
       holder.itemView.setOnClickListener{v:  View ->
            Toast.makeText(v.context,"Clicked on: "+values[position].text,Toast.LENGTH_SHORT).show()

        }
    }

    override fun getItemCount():Int{
        return values.size
    }


   inner class ViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        var image:ImageView
        var textTitle:TextView

        init {

            image = itemView.findViewById(R.id.item_image)
            textTitle = itemView.findViewById(R.id.item_title)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}