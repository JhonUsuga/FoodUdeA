package co.edu.udea.compumovil.gr07_20251.udeafood

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import co.edu.udea.compumovil.gr07_20251.udeafood.R
import androidx.navigation.fragment.findNavController

class CatalogFragment : Fragment() {
    private lateinit var listView: ListView
    val establecimientoList = arrayListOf(
        Establecimiento("bigBurger","Big Burger","Frente al Bloque 15","Cerrado",4.5,3000.0,R.drawable.bigburger),
        Establecimiento("laEmpanada","La Empanada","Detras del Bloque 19","Abierto",5.0,1000.0,R.drawable.laempanada)
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_catalog, container, false)

        val listView = view.findViewById<ListView>(R.id.listView)
        listView.adapter = EstablecimientoAdapter(requireContext().applicationContext,establecimientoList)

        listView.setOnItemClickListener { parent, view, position, id ->
            findNavController().navigate(R.id.establecimientoFragment)
        }
        return view
    }
}
