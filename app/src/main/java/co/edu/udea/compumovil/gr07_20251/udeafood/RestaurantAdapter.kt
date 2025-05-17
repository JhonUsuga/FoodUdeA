package co.edu.udea.compumovil.gr07_20251.udeafood
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.udea.compumovil.gr07_20251.udeafood.R
import co.edu.udea.compumovil.gr07_20251.udeafood.Restaurant

class RestaurantAdapter(
    private val restaurants: List<Restaurant>,
    private val onClick: (Restaurant) -> Unit
) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.img_restaurant)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val type = itemView.findViewById<TextView>(R.id.tv_type)
        val hours = itemView.findViewById<TextView>(R.id.tv_hours)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = restaurants[position]
        holder.name.text = item.name
        holder.type.text = item.type
        holder.hours.text = item.hours
        holder.img.setImageResource(item.imageResId)

        // Click listener para navegar
        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount(): Int = restaurants.size
}