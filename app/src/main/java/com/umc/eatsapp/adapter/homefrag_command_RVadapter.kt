package com.umc.eatsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.umc.eatsapp.data.Storeinfo
import com.umc.eatsapp.databinding.ItemHomefragCommandBinding

class homefrag_command_RVadapter(val context : Context) :
    RecyclerView.Adapter<homefrag_command_RVadapter.viewHolder>() {
    private val store = ArrayList<Storeinfo>()

    //클릭 인터페이스 정의
    interface MyItemClickListener{
        fun onItemClick(store : Storeinfo, position : Int)
    }

    private lateinit var mItemClickListener : MyItemClickListener

    fun setMyItemClickListener(itemCLickLister : MyItemClickListener){
        mItemClickListener = itemCLickLister
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): homefrag_command_RVadapter.viewHolder {
        val binding : ItemHomefragCommandBinding = ItemHomefragCommandBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: homefrag_command_RVadapter.viewHolder, position: Int) {
        holder.bind(store[position])
        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(store[position],position)
        }
    }

    override fun getItemCount(): Int = store.size

    inner class viewHolder(val binding : ItemHomefragCommandBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(store : Storeinfo){
            Glide.with(context).load(store.storeImg).into(binding.homefragCommandImg)
            binding.homefragCommandStorename.text = store.storeName
            binding.homefragCommandNum.text = store.rating.toString() +"("+store.reviewNum.toString()+") · "+store.distance.toString()
        }
    }

    fun addStore(store : ArrayList<Storeinfo>){
        this.store.clear()
        this.store.addAll(store)

        notifyDataSetChanged()
    }

}