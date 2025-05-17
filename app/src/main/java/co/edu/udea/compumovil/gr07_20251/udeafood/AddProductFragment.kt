package co.edu.udea.compumovil.gr07_20251.udeafood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nameInput = view.findViewById<EditText>(R.id.input_product_name)
        val descriptionInput = view.findViewById<EditText>(R.id.input_product_description)
        val priceInput = view.findViewById<EditText>(R.id.input_product_price)
        val addButton = view.findViewById<Button>(R.id.btn_add_product)

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val description = descriptionInput.text.toString()
            val price = priceInput.text.toString().toDoubleOrNull()

            if (name.isBlank() || description.isBlank() || price == null) {
                Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val product = Product(
                name = name,
                description = description,
                price = price,
                imageResId = android.R.drawable.ic_menu_gallery // imagen temporal
            )

            CreateStoreFragment.userStore?.products?.add(product)

            Toast.makeText(requireContext(), "Producto agregado", Toast.LENGTH_SHORT).show()

            // Limpiar campos
            nameInput.text.clear()
            descriptionInput.text.clear()
            priceInput.text.clear()
        }
    }
}
