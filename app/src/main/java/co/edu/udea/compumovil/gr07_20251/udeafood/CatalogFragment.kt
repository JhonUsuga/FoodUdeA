package co.edu.udea.compumovil.gr07_20251.udeafood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView


class CatalogFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.rv_restaurants)

        val sampleRestaurants = listOf(
            Restaurant("Domo UdeA", "Bebidas y repostería", "7:00 a.m. - 5:00 p.m.", R.drawable.domo),
            Restaurant("Empanadas UdeA", "Comida Rapida y snacks", "11:00 a.m. - 3:00 p.m.", R.drawable.empanada),
            Restaurant("Helados UdeA", "Helados y postres", "10:00 a.m. - 4:00 p.m.", R.drawable.helados)
        )

        rv.adapter = RestaurantAdapter(sampleRestaurants) { restaurant ->
            val bundle = Bundle().apply {
                putString("name", restaurant.name)
                putString("type", restaurant.type)
                putString("hours", restaurant.hours)
                putInt("imageResId", restaurant.imageResId)
            }
            findNavController().navigate(R.id.restaurantDetailFragment, bundle)
        }

    }
}
