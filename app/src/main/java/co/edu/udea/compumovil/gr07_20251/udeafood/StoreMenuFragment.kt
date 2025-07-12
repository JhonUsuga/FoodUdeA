package co.edu.udea.compumovil.gr07_20251.udeafood

import android.app.AlertDialog
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StoreMenuFragment : Fragment() {

    private lateinit var adapter: ProductAdapter
    private lateinit var productList: MutableList<Product>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_store_menu, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.rv_products)
        rv.layoutManager = LinearLayoutManager(requireContext())

        productList = CreateStoreFragment.userStore?.products ?: mutableListOf()

        adapter = ProductAdapter(
            productList,
            onEdit = { product, index -> showEditDialog(product, index) },
            onDelete = { index ->
                productList.removeAt(index)
                adapter.notifyItemRemoved(index)
            }
        )

        rv.adapter = adapter
    }

    private fun showEditDialog(product: Product, index: Int) {
        val context = requireContext()
        val inputName = EditText(context).apply { setText(product.name) }
        val inputDesc = EditText(context).apply { setText(product.description) }
        val inputPrice = EditText(context).apply {
            inputType = android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
            setText(product.price.toString())
        }

        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            addView(inputName)
            addView(inputDesc)
            addView(inputPrice)
            setPadding(50, 40, 50, 10)
        }

        AlertDialog.Builder(context)
            .setTitle("Editar producto")
            .setView(layout)
            .setPositiveButton("Guardar") { _, _ ->
                productList[index] = product.copy(
                    name = inputName.text.toString(),
                    description = inputDesc.text.toString(),
                    price = inputPrice.text.toString().toDoubleOrNull() ?: product.price
                )
                adapter.notifyItemChanged(index)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}

