package com.works.fragments

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.works.R

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        val sultanAhmet = LatLng(41.0081071, 28.9711002)
        val sirkeci = LatLng(41.0084071,28.9741002)

        googleMap.addMarker(MarkerOptions().position(sultanAhmet).title("Sultan Ahmet"))
        googleMap.addMarker(MarkerOptions().position(sirkeci).title("Sirkeci"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sultanAhmet))

        // zoom location with zoom level
        val zoomLevel = 15f
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sultanAhmet, zoomLevel))
        googleMap.uiSettings.isZoomControlsEnabled = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}