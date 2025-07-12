package co.edu.udea.compumovil.gr07_20251.udeafood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val productList: MutableList<Product>,
    private val onEdit: (Product, Int) -> Unit,
    private val onDelete: (Int) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.img_product)
        val name = view.findViewById<TextView>(R.id.tv_product_name)
        val desc = view.findViewById<TextView>(R.id.tv_product_desc)
        val price = view.findViewById<TextView>(R.id.tv_product_price)
        val editBtn = view.findViewById<ImageButton>(R.id.btn_edit)
        val deleteBtn = view.findViewById<ImageButton>(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.name.text = product.name
        holder.desc.text = product.description
        holder.price.text = "$${product.price}"
        holder.img.setImageResource(product.imageResId)

        holder.editBtn.setOnClickListener {
            onEdit(product, position)
        }

        holder.deleteBtn.setOnClickListener {
            onDelete(position)
        }
    }
}

