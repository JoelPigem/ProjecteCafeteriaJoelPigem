package com.joelpigem.projectecafeteria.Home.Postres

import androidx.lifecycle.ViewModel
import com.joelpigem.projectecafeteria.Home.DataSource
import com.joelpigem.projectecafeteria.Home.MenuModel

class PostresViewModel: ViewModel() {
    private var _postres: List<MenuModel> = emptyList()
    val postres: List<MenuModel>
        get() = _postres

    fun generarProductes() {
        val productes = DataSource.carregarProductes()
        _postres = productes.filter { producte ->
            producte.tipus == "postres"
        }
    }
}