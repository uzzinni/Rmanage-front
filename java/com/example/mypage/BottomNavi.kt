package com.example.mypage
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavi : Fragment() {

    private lateinit var bottomNavigationView: BottomNavigationView

    @SuppressLint("CutPasteId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_main, container, false)
        bottomNavigationView = rootView.findViewById(R.id.bottom_navi)


        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item1 -> {
                    val intent = Intent(requireActivity(), Setting::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item2 -> {
                    val intent2 = Intent(requireActivity(), Email::class.java)
                    startActivity(intent2)
                    true
                }
                R.id.item3 -> {
                    val intent3 = Intent(requireActivity(), DocumentPlus::class.java)
                    startActivity(intent3)
                    true
                }
                R.id.item4 -> {
                    val intent4 = Intent(requireActivity(), Alarm::class.java)
                    startActivity(intent4)
                    true
                }
                R.id.item5 -> {
                    val intent5 = Intent(requireActivity(), MainActivity::class.java)
                    startActivity(intent5)
                    true
                }
                else -> false
            }
        }

        return rootView
    }
}
