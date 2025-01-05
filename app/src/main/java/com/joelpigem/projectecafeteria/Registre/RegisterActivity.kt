package com.joelpigem.projectecafeteria.Registre

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
import com.joelpigem.projectecafeteria.Login.LoginViewModel
import com.joelpigem.projectecafeteria.Login.MainActivity
import com.joelpigem.projectecafeteria.R
import com.joelpigem.projectecafeteria.databinding.ActivityMainBinding
import com.joelpigem.projectecafeteria.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private val viewModel: RegistreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityRegisterBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_register
        )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonRegistre.setOnClickListener{
            viewModel.setUsuari(binding.editTextMail.text.toString(), binding.editTextName.text.toString(), binding.editTextPassword.text.toString())
            if (viewModel.usuariComprovat) {
                Toast.makeText(this,
                    getString(R.string.usuari) + viewModel.usuari.toString() + getString(R.string.creat), Toast.LENGTH_SHORT).show()

                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                if (viewModel.usuariExistent) {
                    Toast.makeText(this,
                        getString(R.string.ja_existeix_un_usuari_amb_aquestes_credencials), Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(
                        this,
                        getString(R.string.emplena_tots_els_camps),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.textViewFooter.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}