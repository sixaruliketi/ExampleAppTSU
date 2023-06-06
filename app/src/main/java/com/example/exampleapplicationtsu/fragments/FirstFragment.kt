package com.example.exampleapplicationtsu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampleapplicationtsu.Item
import com.example.exampleapplicationtsu.ItemRecyclerViewAdapter
import com.example.exampleapplicationtsu.databinding.FragmentFirstBinding
import com.example.exampleapplicationtsu.databinding.FragmentSecondBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.snapshots

class FirstFragment: Fragment() {
    private lateinit var _binding : FragmentFirstBinding
    private val binding get() = _binding
    lateinit var itemRecyclerViewAdapter: ItemRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemRecyclerViewAdapter = ItemRecyclerViewAdapter(getData())
        binding.apply {
            myRV.adapter = itemRecyclerViewAdapter
            myRV.layoutManager = LinearLayoutManager(context)

            val navigation = findNavController()
            itemRecyclerViewAdapter.onClick = {
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                    it.text1!!, it.text2!!, it.text3!!
                )
                navigation.navigate(action)
            }
        }
    }

    private var db  = FirebaseDatabase.getInstance().getReference("ITEMS")
    private fun getData(): MutableList<Item> {
        var listItem = ArrayList<Item>()
        db.child("item").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val item = snapshot.getValue(Item::class.java) ?: return
                listItem.add(item)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return listItem
    }
}