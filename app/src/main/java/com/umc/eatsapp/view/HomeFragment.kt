package com.umc.eatsapp.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.umc.eatsapp.Category
import com.umc.eatsapp.R
import com.umc.eatsapp.adapter.homefrag_banner_pageradapter
import com.umc.eatsapp.adapter.homefrag_category_RVadapter
import com.umc.eatsapp.adapter.homefrag_command_RVadapter
import com.umc.eatsapp.data.Storeinfo
import com.umc.eatsapp.databinding.FragmentHomeBinding
import com.umc.eatsapp.service.StoreService
import com.umc.eatsapp.serviceView.CatView
import com.umc.eatsapp.serviceView.StoreView

class HomeFragment :  Fragment(),CatView,StoreView{

    private val handler = Handler(Looper.getMainLooper())
    private lateinit var banner : Banner

    lateinit var binding : FragmentHomeBinding
    private lateinit var categoryAdatper : homefrag_category_RVadapter
    private lateinit var commandAdapter : homefrag_command_RVadapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initCategoryRV()
        initBanner()
        initCommandRV()

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        getCat()
        getStore()
    }

    private fun getStore() {
        val StoreService = StoreService()
        StoreService.setStoreView(this)
        StoreService.store("popular")
    }

    private fun getCat() {
        val catService = StoreService()
        catService.setCatView(this)
        catService.category()
    }

    private fun initCommandRV() {
        commandAdapter = homefrag_command_RVadapter(requireContext())
        binding.homefragCommandRv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.homefragCommandRv.adapter = commandAdapter
    }

    private fun initBanner(){
        val bannerAdapter = homefrag_banner_pageradapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_homefrag_1))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_homefrag_2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_homefrag_3))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_homefrag_4))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_homefrag_5))


        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        banner = Banner(0)
        banner.start()
    }

    inner class Banner(private var currentPos : Int) : Thread(){
        override fun run() {
            while(true){
                sleep(5000)
                handler.post {
                    if(currentPos==5) currentPos=0
                    binding.bannerNum.text = (currentPos+1).toString() + " / 5"
                    binding.homeBannerVp.setCurrentItem(currentPos,true)
                    currentPos+=1
                }
            }
        }
    }

    private fun initCategoryRV() {
        categoryAdatper = homefrag_category_RVadapter(requireContext())
        binding.homefragCategoryRv.layoutManager = GridLayoutManager(context,2, LinearLayoutManager.HORIZONTAL, false)
        binding.homefragCategoryRv.adapter = categoryAdatper
    }

    override fun onCatLoading() {
    }

    override fun onCatSuccess(cats : ArrayList<Category>) {
        categoryAdatper.addCategory(cats)
    }

    override fun onCatFailure(code: Int, message: String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }

    override fun onStoreLoading() {
        Toast.makeText(requireContext(),"로딩중.", Toast.LENGTH_SHORT).show()
    }

    override fun onStoreSuccess(stores: ArrayList<Storeinfo>) {
        Toast.makeText(requireContext(),"성공.", Toast.LENGTH_SHORT).show()
        commandAdapter.addStore(stores)
    }

    override fun onStoreFailure(code: Int, message: String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }
}