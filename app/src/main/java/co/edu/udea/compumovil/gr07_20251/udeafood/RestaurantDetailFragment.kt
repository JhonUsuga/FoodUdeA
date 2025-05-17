package co.edu.udea.compumovil.gr07_20251.udeafood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class RestaurantDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = arguments?.getString("name")
        val type = arguments?.getString("type")
        val hours = arguments?.getString("hours")
        val imageResId = arguments?.getInt("imageResId") ?: 0

        view.findViewById<TextView>(R.id.detail_name).text = name
        view.findViewById<TextView>(R.id.detail_type).text = type
        view.findViewById<TextView>(R.id.detail_hours).text = hours
        view.findViewById<ImageView>(R.id.detail_image).setImageResource(imageResId)
    }
}
