package com.fadhel.mapsmuhamadfadhel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.fadhel.mapsmuhamadfadhel.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker

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

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

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