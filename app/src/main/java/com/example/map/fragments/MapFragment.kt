package com.example.map.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.map.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*


class MapFragment : Fragment() {
    private val callback = OnMapReadyCallback {googleMap ->
        val sydney = LatLng(-34.0,151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker by MadFlasher"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        @Suppress("DEPRECATION")
        top_toolbar.setOnApplyWindowInsetsListener { _, windowInsets ->
            val bottomNav = top_toolbar.layoutParams as ViewGroup.MarginLayoutParams
            bottomNav.setMargins(20,windowInsets.systemWindowInsetTop + 20,20,20)
            windowInsets
        }
        Glide.with(this)
                .load("https://picsum.photos/200")
                .into(userImage)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(callback)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        Glide.with(this)
//            .load("https://picsum.photos/200")
//            .into(userImage)

        return inflater.inflate(R.layout.fragment_map, container, false)
    }
}