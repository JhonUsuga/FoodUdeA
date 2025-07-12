package co.edu.udea.compumovil.gr07_20251.udeafood

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MapFragment : Fragment() {

    private lateinit var map: MapView

    private fun getBitmapIcon(drawableResId: Int): android.graphics.drawable.BitmapDrawable {
        val drawable = requireContext().getDrawable(drawableResId) ?: return BitmapDrawable()

        val width = 80
        val height = 80

        val bitmap = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888)
        val canvas = android.graphics.Canvas(bitmap)
        drawable.setBounds(0, 0, width, height)
        drawable.draw(canvas)

        return android.graphics.drawable.BitmapDrawable(resources, bitmap)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Configuration.getInstance().load(requireContext(), requireContext().getSharedPreferences("osmdroid", 0))
        return inflater.inflate(R.layout.fragment_osm_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        map = view.findViewById(R.id.osm_map)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)

        val startPoint = GeoPoint(6.2675, -75.5686)
        map.controller.setZoom(18.0)
        map.controller.setCenter(startPoint)

        val fakeStores = listOf(
            Store(
                name = "Domo UdeA",
                location = "Bloque A",
                open = true,
                hours = "7:00 - 17:00",
                minPrice = 3000,
                imageResId = R.drawable.domo,
                description = "Frente al bloque 15"
            ),
            Store(
                name = "Empanadas UdeA",
                location = "Bloque B",
                open = true,
                hours = "11:00 - 15:00",
                minPrice = 2500,
                imageResId = R.drawable.empanada,
                description = "Al lado del parqueadero"
            ),
            Store(
                name = "Helados UdeA",
                location = "Bloque C",
                open = true,
                hours = "10:00 - 16:00",
                minPrice = 4000,
                imageResId = R.drawable.helados,
                description = "Detrás de la cafetería"
            )
        )


        val locations = listOf(
            GeoPoint(6.2676, -75.5680),
            GeoPoint(6.2678, -75.5670),
            GeoPoint(6.2672, -75.5685)
        )

        for ((index, store) in fakeStores.withIndex()) {
            val marker = Marker(map)
            marker.position = locations[index]
            marker.title = store.name
            marker.subDescription = "Horario: ${store.hours}\nDesde $${store.minPrice}"
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            marker.icon = getBitmapIcon(store.imageResId)
            marker.setOnMarkerClickListener { m, _ ->
                m.showInfoWindow()
                true
            }
            map.overlays.add(marker)
        }


        // También mostrar la tienda del usuario (si existe)
        CreateStoreFragment.userStore?.let { store ->
            val marker = Marker(map)
            marker.position = GeoPoint(6.2675, -75.5675)
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            marker.title = "${store.name} - ${store.hours}"
            marker.subDescription = "Desde $${store.minPrice}"
            marker.setOnMarkerClickListener { m, _ ->
                m.showInfoWindow()
                true
            }
            map.overlays.add(marker)
        }
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}
