package com.joelpigem.projectecafeteria.Home.Beguda

import androidx.lifecycle.ViewModel
import com.joelpigem.projectecafeteria.Home.DataSource
import com.joelpigem.projectecafeteria.Home.MenuModel

class BegudaViewModel: ViewModel() {
    private var _begudes: List<MenuModel> = emptyList()
    val begudes: List<MenuModel>
        get() = _begudes

    fun generarProductes() {
        val productes = DataSource.carregarProductes()
        _begudes = productes.filter { producte ->
            producte.tipus == "beguda"
        }
    }
}