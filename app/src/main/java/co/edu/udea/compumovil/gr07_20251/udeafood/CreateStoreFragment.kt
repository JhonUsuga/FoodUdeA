package co.edu.udea.compumovil.gr07_20251.udeafood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.util.UUID

class CreateStoreFragment : Fragment() {

    companion object {
        var userStore: Store? = null  // 🔒 Guardar en memoria por ahora
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = view.findViewById<EditText>(R.id.input_store_name)
        val location = view.findViewById<EditText>(R.id.input_store_location)
        val hours = view.findViewById<EditText>(R.id.input_store_hours)
        val price = view.findViewById<EditText>(R.id.input_min_price)
        val isOpen = view.findViewById<CheckBox>(R.id.check_open)
        val saveBtn = view.findViewById<Button>(R.id.btn_save_store)

        saveBtn.setOnClickListener {
            val store = Store(
                name = name.text.toString(),
                location = location.text.toString(),
                hours = hours.text.toString(),
                minPrice = price.text.toString().toIntOrNull() ?: 0,
                open = isOpen.isChecked,
                imageResId = R.drawable.ic_udea_logo
            )

            userStore = store

            Toast.makeText(requireContext(), "Tienda creada correctamente", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.addProductFragment) // 🚀 siguiente paso
        }
    }
}
