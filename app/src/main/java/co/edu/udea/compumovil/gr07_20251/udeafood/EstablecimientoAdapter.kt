package co.edu.udea.compumovil.gr07_20251.udeafood

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class EstablecimientoAdapter(private val context: Context,
                             private val establecimientoList: ArrayList<Establecimiento>
): ArrayAdapter<Establecimiento>(context, R.layout.establecimiento_layout,establecimientoList ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.establecimiento_layout,parent,false)

        val establecimientoImg = view.findViewById<ImageView>(R.id.establecimientoImg)
        val establecimientoTxt = view.findViewById<TextView>(R.id.establecimientoTxt)

        val establecimiento = establecimientoList[position]

        establecimientoImg.setImageResource(establecimiento.logo)
        establecimientoTxt.text = establecimiento.nombre

        return view
    }
}