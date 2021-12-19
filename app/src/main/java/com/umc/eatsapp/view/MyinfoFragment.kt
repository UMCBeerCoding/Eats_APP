package com.umc.eatsapp.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.umc.eatsapp.R
import com.umc.eatsapp.adapter.homefrag_banner_pageradapter
import com.umc.eatsapp.data.User
import com.umc.eatsapp.databinding.FragmentMyinfoBinding
import com.umc.eatsapp.getUserinfo

class MyinfoFragment : Fragment() {
    lateinit var binding : FragmentMyinfoBinding

    private val handler = Handler(Looper.getMainLooper())
    private lateinit var banner : Banner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyinfoBinding.inflate(inflater,container,false)
        binding.myinfoScrollview.fullScroll(ScrollView.FOCUS_DOWN);
        initBanner()
        initInfo()

        return binding.root
    }

    private fun initInfo() {
        val user : User = getUserinfo(requireContext())
        binding.myinfoName.text= user.name
        binding.myinfoPhonenum.text = user.phoneNum
    }

    private fun initBanner(){
        val bannerAdapter = homefrag_banner_pageradapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_homefrag_1))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_homefrag_2))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_homefrag_3))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_homefrag_4))
        bannerAdapter.addFragment(BannerFragment(R.drawable.banner_homefrag_5))

        binding.myinfoBannerVp.adapter = bannerAdapter
        binding.myinfoBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        banner = Banner(0)
        banner.start()
    }

    inner class Banner(private var currentPos : Int) : Thread(){
        override fun run() {
            while(true){
                sleep(3000)
                handler.post {
                    if(currentPos==5) currentPos=0
                    binding.bannerNum.text = (currentPos+1).toString() + " / 5"
                    binding.myinfoBannerVp.setCurrentItem(currentPos,true)
                    currentPos+=1
                }
            }
        }
    }
}