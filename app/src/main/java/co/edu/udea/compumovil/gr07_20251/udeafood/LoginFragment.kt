package co.edu.udea.compumovil.gr07_20251.udeafood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Campos de entrada y botón
        val emailInput = view.findViewById<EditText>(R.id.input_email)
        val passwordInput = view.findViewById<EditText>(R.id.input_password)
        val loginButton = view.findViewById<Button>(R.id.btn_login)

        // ✅ Este es el botón de "crear cuenta"
        val createAccount = view.findViewById<TextView>(R.id.tv_create_account)
        createAccount.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }

        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Simulación de login correcto
                if (email == "estudiante@udea.edu.co" && password == "1234") {
                    findNavController().navigate(R.id.homeFragment)
                } else {
                    Toast.makeText(requireContext(), "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }
}
