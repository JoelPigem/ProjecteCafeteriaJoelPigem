package com.joelpigem.projectecafeteria.Registre

import androidx.lifecycle.ViewModel
import com.joelpigem.projectecafeteria.DataSourceUsers
import com.joelpigem.projectecafeteria.Home.DataSource
import com.joelpigem.projectecafeteria.Home.MenuModel
import com.joelpigem.projectecafeteria.UsersModel

class RegistreViewModel: ViewModel() {

    private var _usuari: String = ""
    val usuari: String
        get() = _usuari

    private var _usuariComprovat: Boolean = false
    val usuariComprovat: Boolean
        get() = _usuariComprovat

    private var _usuariExistent: Boolean = false
    val usuariExistent: Boolean
        get() = _usuariExistent


    fun setUsuari(mail: String, usuari: String, contrassenya: String) {
        val users = DataSourceUsers.carregarUsers()

        val usuariExisteix = users.any { user ->
            user.nom == usuari || user.email == mail
        }

        if (usuariExisteix) {
            _usuariComprovat = false
            _usuariExistent = true
        } else if (mail.isNotEmpty() && usuari.isNotEmpty() && contrassenya.isNotEmpty()) {
            _usuari = usuari
            _usuariComprovat = true
            _usuariExistent = false
            users.add(UsersModel(usuari, mail, contrassenya))
        } else {
            _usuariComprovat = false
            _usuariExistent = false
        }
    }


}