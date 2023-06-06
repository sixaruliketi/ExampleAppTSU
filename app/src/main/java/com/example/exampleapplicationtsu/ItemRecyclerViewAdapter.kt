package com.example.exampleapplicationtsu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapplicationtsu.databinding.ItemViewBinding

class ItemRecyclerViewAdapter(val listItem: MutableList<Item>) : RecyclerView.Adapter<ItemRecyclerViewAdapter.MyViewHolder>() {

    var onClick: ((Item) -> Unit)?=null

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = ItemViewBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listItem[position]
        holder.binding.apply {
            text1.text = item.text1
            text2.text = item.text2
            text3.text = item.text3
        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(item)
        }
    }
    override fun getItemCount() = listItem.size

}