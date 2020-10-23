package com.example.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var gMap: GoogleMap
//    private lateinit var fullscreenContent: TextView
//    private lateinit var fullscreenContentControls: LinearLayout
//    private val hideHandler = Handler()
//    private var isFullscreen: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val view: CoordinatorLayout = findViewById(R.id.cd)
        view.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

//        fullscreenContentControls = findViewById(R.id.cd)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }
//
//    private fun toggle() {
//        if (isFullscreen) {
//            hide()
//        } else {
//            show()
//        }
//    }

//    private fun show() {
//        fullscreenContentControls = findViewById(R.id.cd)
//        fullscreenContentControls.systemUiVisibility =
//            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
//                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//        isFullscreen = true
//    }
//
//    private fun hide() {
//        fullscreenContentControls = findViewById(R.id.cd)
//        fullscreenContentControls.visibility = View.GONE
//        isFullscreen = false
//    }

    override fun onMapReady(googleMap: GoogleMap) {
        gMap = googleMap
        //custom marker
        val sydney = LatLng(-34.0, 151.0)
        gMap.addMarker(MarkerOptions().position(sydney).title("Marker by MadFlasher"))
        gMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}