package com.joelpigem.projectecafeteria.Login

import androidx.lifecycle.ViewModel
import com.joelpigem.projectecafeteria.DataSourceUsers
import com.joelpigem.projectecafeteria.Home.DataSource
import com.joelpigem.projectecafeteria.Home.MenuModel
import com.joelpigem.projectecafeteria.UsersModel

class LoginViewModel: ViewModel() {
    private var _usuari: String = ""
    val usuari: String
        get() = _usuari

    private var _contrassenya: String = ""
    val contrassenya: String
        get() = _contrassenya

    private var _usuariComprovat: Boolean = false
    val usuariComprovat: Boolean
        get() = _usuariComprovat

    private var _usuariActual: UsersModel? = null
    val usuariActual: UsersModel?
        get() = _usuariActual

    fun setUsuari(usuari: String, contrassenya: String) {
        _usuari = usuari
        _contrassenya = contrassenya
    }

    fun comprovarUsuari() {
        val users = DataSourceUsers.carregarUsers()
        _usuariActual = users.firstOrNull { user ->
            user.nom == usuari && user.contrassenya == contrassenya
        }
        _usuariComprovat = _usuariActual != null
    }

}