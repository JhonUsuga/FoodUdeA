package co.edu.udea.compumovil.gr07_20251.udeafood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView


class PickLocationFragment : Fragment() {
    private lateinit var map: MapView

    companion object {
        var selectedLocation: GeoPoint? = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Configuration.getInstance().load(requireContext(), requireContext().getSharedPreferences("osmdroid", 0))
        return inflater.inflate(R.layout.fragment_pick_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        map = view.findViewById(R.id.osm_map)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)

        val defaultCenter = GeoPoint(6.2675, -75.5686)
        map.controller.setZoom(18.0)
        map.controller.setCenter(defaultCenter)

        map.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val proj = map.projection
                val point = proj.fromPixels(event.x.toInt(), event.y.toInt()) as GeoPoint
                selectedLocation = point
                findNavController().popBackStack() // Volver al fragmento anterior
            }
            true
        }
    }
}