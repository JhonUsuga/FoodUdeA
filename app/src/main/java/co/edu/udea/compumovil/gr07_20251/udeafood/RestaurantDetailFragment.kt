package co.edu.udea.compumovil.gr07_20251.udeafood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RestaurantDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = arguments?.getString("name")
        val hours = arguments?.getString("hours")
        val imageResId = arguments?.getInt("imageResId") ?: 0
        val description = arguments?.getString("description")
        val location = arguments?.getString("location")
        val minPrice = arguments?.getInt("minPrice") ?: 0
        val backButton = view.findViewById<Button>(R.id.btn_back_to_list)
        backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<TextView>(R.id.detail_name).text = name
        view.findViewById<TextView>(R.id.detail_hours).text = hours
        view.findViewById<ImageView>(R.id.detail_image).setImageResource(imageResId)
        view.findViewById<TextView>(R.id.textUbicacion).text = location
        view.findViewById<TextView>(R.id.textDescripcion).text = description
        view.findViewById<TextView>(R.id.textPrecioDesde).text = "" + minPrice
    }
}
