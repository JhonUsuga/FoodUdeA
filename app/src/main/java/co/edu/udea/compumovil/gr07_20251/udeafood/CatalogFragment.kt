package co.edu.udea.compumovil.gr07_20251.udeafood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import co.edu.udea.compumovil.gr07_20251.udeafood.R

class CatalogFragment : Fragment() {
    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_catalog, container, false)
        val listView = view.findViewById<ListView>(R.id.listView)
        return view
    }
}
