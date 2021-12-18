package com.umc.eatsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.umc.eatsapp.Category
import com.umc.eatsapp.databinding.ItemSearchCategoryBinding

class search_category_RVadapter(val context : Context) :
        RecyclerView.Adapter<search_category_RVadapter.viewHolder>() {
    private val category = ArrayList<Category>()

    //클릭 인터페이스 정의
    interface MyItemClickListener{
        fun onItemClick(category : Category, position : Int)
    }

    private lateinit var mItemClickListener : MyItemClickListener

    fun setMyItemClickListener(itemCLickLister : MyItemClickListener){
        mItemClickListener = itemCLickLister
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): search_category_RVadapter.viewHolder {
        val binding : ItemSearchCategoryBinding = ItemSearchCategoryBinding.inflate(
                LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: search_category_RVadapter.viewHolder, position: Int) {
        holder.bind(category[position])
        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(category[position],position)
        }
    }

    override fun getItemCount(): Int = category.size

    inner class viewHolder(val binding : ItemSearchCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (category : Category){
            Glide.with(context).load(category.catImage).into(binding.categoryImg)
            binding.categoryText.text = category.catName
        }
    }

    fun addCategory(category : ArrayList<Category>){
        this.category.clear()
        this.category.addAll(category)
        notifyDataSetChanged()
    }

}