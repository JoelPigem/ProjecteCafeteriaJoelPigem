package com.joelpigem.projectecafeteria.Home.Menjar

import androidx.lifecycle.ViewModel
import com.joelpigem.projectecafeteria.Home.DataSource
import com.joelpigem.projectecafeteria.Home.MenuModel

class MenjarsViewModel: ViewModel() {
    private var _menjars: List<MenuModel> = emptyList()
    val menjars: List<MenuModel>
        get() = _menjars

    fun generarProductes() {
        val productes = DataSource.carregarProductes()
        _menjars = productes.filter { producte ->
            producte.tipus == "menjar"
        }
    }
}