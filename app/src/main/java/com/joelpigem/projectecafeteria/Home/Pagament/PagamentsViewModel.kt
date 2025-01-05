package com.joelpigem.projectecafeteria.Home.Pagament

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joelpigem.projectecafeteria.Home.MenuModel

class PagamentsViewModel: ViewModel() {
    private val _productes = MutableLiveData<List<MenuModel>>()
    val productes: LiveData<List<MenuModel>>
        get() = _productes

    fun generarProductes(menjars: LiveData<MutableList<MenuModel>>, begudes: LiveData<MutableList<MenuModel>>, postres: LiveData<MutableList<MenuModel>>) {
        val totalProductes = mutableListOf<MenuModel>()

        menjars.value?.let { totalProductes.addAll(it) }
        begudes.value?.let { totalProductes.addAll(it) }
        postres.value?.let { totalProductes.addAll(it) }


        _productes.value = totalProductes
    }
}