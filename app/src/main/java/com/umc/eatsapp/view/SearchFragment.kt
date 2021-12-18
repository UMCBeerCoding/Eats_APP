package com.umc.eatsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.eatsapp.Category
import com.umc.eatsapp.adapter.homefrag_category_RVadapter
import com.umc.eatsapp.databinding.FragmentSearchBinding
import com.umc.eatsapp.service.StoreService
import com.umc.eatsapp.serviceView.CatView

class SearchFragment: Fragment(), CatView {
    lateinit var binding : FragmentSearchBinding
    private lateinit var categoryAdatper : homefrag_category_RVadapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)

        initRV()

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        getCat()
    }

    private fun getCat() {
        val catService = StoreService()
        catService.setCatView(this)
        catService.category()
    }

    private fun initRV() {
        categoryAdatper = homefrag_category_RVadapter(requireContext())
        binding.searchfragRv.layoutManager = GridLayoutManager(context,3, LinearLayoutManager.HORIZONTAL, false)
        binding.searchfragRv.adapter = categoryAdatper
    }


    override fun onCatLoading() {
    }

    override fun onCatSuccess(cats : ArrayList<Category>) {
        categoryAdatper.addCategory(cats)
    }

    override fun onCatFailure(code: Int, message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }
}
