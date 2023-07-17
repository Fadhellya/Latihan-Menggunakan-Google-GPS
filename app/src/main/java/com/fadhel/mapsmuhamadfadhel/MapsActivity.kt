package com.fadhel.mapsmuhamadfadhel

import android.content.ContentValues.TAG
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem


import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.fadhel.mapsmuhamadfadhel.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.*
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    val zoom = 13F
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.maps_options,menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.normal_maps -> {
            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            true
        }
        R.id.hybrid_maps -> {
            mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
            true
        }
        R.id.satellite_maps -> {
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
            true
        }
        R.id.terrain_maps -> {
            mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
    private fun setMapLongClick(map: GoogleMap){
        map.setOnMapLongClickListener { latlang ->
            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1.5f, Long: %2$.5f",
                latlang.latitude,
                latlang.longitude
            )
            map.addMarker(
                MarkerOptions()
                    .position(latlang)
                    .title("Drop Pin")
                    .snippet(snippet)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconmall))
            )
        }
    }

        private fun setMapstyle(googleMap: GoogleMap){

            try {
                val succes = googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this,R.raw.map_styles))
                if(!succes){
                    Log.e(TAG,"Perubahan Style Maps Gagal")
                }
            }catch (e:Resources.NotFoundException){
                Log.e(TAG,"Tidak bisa menemukan Resources Style Maps yang baru")
            }

        }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        setMapstyle(googleMap)
        setMapLongClick(googleMap)
        val ampera = LatLng(-0.9239349776951578, 100.4427197796989)
        var markerAmpera: Marker?=null
        markerAmpera= mMap.addMarker(
            MarkerOptions()
                .position(ampera)
                .title("Ampera Bukan Dia").snippet("Nasi Prasmanan")
                //.icon(BitmapDescriptorFactory.defaultMarker())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconresto))
        )
        markerAmpera?.tag=0

        val basko = LatLng(-0.9020027489680823, 100.35093258175712)
        var markerBasko: Marker?=null
        markerBasko= mMap.addMarker(
            MarkerOptions()
                .position(basko)
                .title("Basko Padang").snippet("Mall Terbesar Di Padang")
                // .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconmall))
        )
        markerBasko?.tag=0

        val pa = LatLng(-0.9498494244548746, 100.35545919525188)
        var markerPa: Marker?=null
        markerPa= mMap.addMarker(
            MarkerOptions()
                .position(pa)
                .title("Plaza Andalas").snippet("Mall yang berada di kota padang")
                //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconmall))
        )
        markerPa?.tag=0

        val masjid = LatLng(-0.924200197227326, 100.36251101038619)
        var markerMasjid: Marker?=null
        markerMasjid= mMap.addMarker(
            MarkerOptions()
                .position(masjid)
                .title("Masjid Raya Sumbar").snippet("Masjid yang diakui di ASEAN")
                //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconsmasjid))
        )
        markerMasjid?.tag=0
        val tm = LatLng(-0.9124467671527503, 100.35738963758169)
        var markerTm: Marker?=null
        markerTm= mMap.addMarker(
            MarkerOptions()
                .position(tm)
                .title("Transmart Padang").snippet("Mall besar yang baru di kota padang")
                //.icon(BitmapDescriptorFactory.defaultMarker())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconmall))
        )
        markerTm?.tag=0



        // Add a marker in Sydney and move the camera
        val padang = LatLng(-0.9436158612218682, 100.36720575469975)
        mMap.addMarker(MarkerOptions().position(padang).title("RSUP M.Jamil Padang"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(padang,zoom))
    }
}