package com.joelpigem.projectecafeteria.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.joelpigem.projectecafeteria.Home.HomeActivity
import com.joelpigem.projectecafeteria.R
import com.joelpigem.projectecafeteria.Registre.RegisterActivity
import com.joelpigem.projectecafeteria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()
    val keyNom = "nom_key"
    val keyMail = "mail_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonLogin.setOnClickListener{
            viewModel.setUsuari(binding.editTextName.text.toString(), binding.editTextPassword.text.toString())
            viewModel.comprovarUsuari()
            if (viewModel.usuariComprovat) {

                val intent = Intent(applicationContext, HomeActivity::class.java)
                val usuari = viewModel.usuariActual

                val nomUsuari = usuari?.nom
                val mailUsuari = usuari?.email

                intent.putExtra(keyNom, nomUsuari)
                intent.putExtra(keyMail, mailUsuari)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuari o contrassenya incorrectes.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textViewFooter.setOnClickListener{
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}