package co.edu.udea.compumovil.gr07_20251.udeafood

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.graphics.Color

class EstablecimientoAdapter(private val context: Context,
                             private val establecimientoList: ArrayList<Establecimiento>
): ArrayAdapter<Establecimiento>(context, R.layout.establecimiento_layout,establecimientoList ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.establecimiento_layout,parent,false)

        val establecimientoImg = view.findViewById<ImageView>(R.id.establecimientoImg)
        val establecimientoTxt = view.findViewById<TextView>(R.id.establecimientoTxt)
        val establecimientoMinimo = view.findViewById<TextView>(R.id.textPrecio)
        val establecimientoUbicacion = view.findViewById<TextView>(R.id.textUbicacion)
        val establecimientoRating = view.findViewById<TextView>(R.id.textRating)
        val establecimientoEstado = view.findViewById<ImageView>(R.id.iconEstado)
        val establecimientoEstadoTxt = view.findViewById<TextView>(R.id.textEstado)

        val establecimiento = establecimientoList[position]

        establecimientoImg.setImageResource(establecimiento.logo)
        establecimientoTxt.text = establecimiento.nombre
        establecimientoUbicacion.text = establecimiento.ubicacion
        establecimientoRating.text = "" + establecimiento.puntuacion
        establecimientoMinimo.text = "Desde $" + establecimiento.precioMinimo
        establecimientoEstadoTxt.text = establecimiento.estado
        if (establecimiento.estado == "Abierto") {
            establecimientoEstado.setImageResource(R.drawable.ic_abierto)
        }
        if (establecimiento.estado == "Cerrado") {
            establecimientoEstadoTxt.setTextColor(0xff000000.toInt())
            establecimientoEstado.setImageResource(R.drawable.ic_cerrado)
        }

        return view
    }
}