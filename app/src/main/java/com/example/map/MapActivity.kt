package com.example.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.map.fragments.MapFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_map.*

class MapActivity : AppCompatActivity() {

//    private lateinit var gMap: GoogleMap
//    private lateinit var fullscreenContent: TextView
//    private lateinit var fullscreenContentControls: LinearLayout
//    private val hideHandler = Handler()
//    private var isFullscreen: Boolean = false
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val view: CoordinatorLayout = findViewById(R.id.cd)
        view.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

        val map = MapFragment()
//        val places = Cart()
//        val profile = Profile()
        setCurrentFragment(map)
        bottomNav = bottomNavigationView
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_map -> setCurrentFragment(map)
                R.id.menu_places -> setCurrentFragment(map)
                R.id.menu_profile -> setCurrentFragment(map)
            }
            true
        }
//        fullscreenContentControls = findViewById(R.id.cd)
//        val bottomNav = findViewById<View>(R.id.bottomNavigationView)
//        bottomNav.setOnApplyWindowInsetsListener { v, insets ->
//            v.updatePadding(bottom = insets.systemWindowInsetBottom)
//            insets
//        }

//        top_toolbar.setOnApplyWindowInsetsListener { view, windowInsets ->
//            val bottomNav = top_toolbar.layoutParams as ViewGroup.MarginLayoutParams
//            bottomNav.setMargins(20,windowInsets.systemWindowInsetTop + 20,20,20)
//            windowInsets
//        }
    }

    private fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_Holder,fragment)
            commit()
        }
    }
}