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

        val sampleStores = listOf(
            Store("10394","Domo UdeA", "Ubicacion", "Algo sobre el restaurante", true, "7:00 a.m. - 5:00 p.m.", 2000,  R.drawable.domo),
            Store("31241","Empanadas UdeA", "Ubicacion", "Algo sobre el restaurante", true, "11:00 a.m. - 3:00 p.m.", 3000, R.drawable.empanada),
            Store("55253","Helados UdeA", "Ubicacion", "Algo sobre el restaurante", true, "10:00 a.m. - 4:00 p.m.", 5000, R.drawable.helados)
        )

        rv.adapter = StoreAdapter(sampleStores) { store ->
            val bundle = Bundle().apply {
                putString("name", store.name)
                putString("hours", store.hours)
                putInt("imageResId", store.imageResId)
            }
            findNavController().navigate(R.id.restaurantDetailFragment, bundle)
        }

    }
}
