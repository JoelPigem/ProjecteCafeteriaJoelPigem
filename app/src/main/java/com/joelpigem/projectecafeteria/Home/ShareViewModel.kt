package com.joelpigem.projectecafeteria.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {


    private val _menjar = MutableLiveData<MutableList<MenuModel>>()
    val menjar: LiveData<MutableList<MenuModel>> = _menjar

    private val _beguda = MutableLiveData<MutableList<MenuModel>>()
    val beguda: LiveData<MutableList<MenuModel>> = _beguda

    private val _postres = MutableLiveData<MutableList<MenuModel>>()
    val postres: LiveData<MutableList<MenuModel>> = _menjar


    private val _preuTotalMenjar = MutableLiveData<Int>()
    val preuTotalMenjar: LiveData<Int> = _preuTotalMenjar

    private val _preuTotalBeguda = MutableLiveData<Int>()
    val preuTotalBeguda: LiveData<Int> = _preuTotalBeguda

    private val _preuTotalPostres = MutableLiveData<Int>()
    val preuTotalPostres: LiveData<Int> = _preuTotalPostres

    private val _preuTotal = MutableLiveData<Int>()
    val preuTotal: LiveData<Int> = _preuTotal


    fun afegirAlMenu(menuModel: MenuModel) {
        if (menuModel.tipus == "menjar") {
            val menjarList = _menjar.value ?: mutableListOf()
            menjarList.add(menuModel)
            _menjar.value = menjarList
        } else if (menuModel.tipus == "beguda") {
            val begudaList = _beguda.value ?: mutableListOf()
            begudaList.add(menuModel)
            _beguda.value = begudaList
        } else {
            val postresList = _postres.value ?: mutableListOf()
            postresList.add(menuModel)
            _postres.value = postresList
        }

        calcularPreuTotal()
    }

    fun calcularPreuTotal() {
        _preuTotalMenjar.value = _menjar.value?.sumOf { it.preuUnitari * it.quantitat } ?: 0

        _preuTotalBeguda.value = _beguda.value?.sumOf { it.preuUnitari * it.quantitat } ?: 0

        _preuTotalPostres.value = _postres.value?.sumOf { it.preuUnitari * it.quantitat } ?: 0

        _preuTotal.value = (_preuTotalMenjar.value ?: 0) + (_preuTotalBeguda.value ?: 0) + (_preuTotalPostres.value ?: 0)
    }

    fun comprar() {
        _menjar.value = mutableListOf()
        _beguda.value = mutableListOf()
        _postres.value = mutableListOf()

        _preuTotalMenjar.value = 0
        _preuTotalBeguda.value = 0
        _preuTotalPostres.value = 0
        _preuTotal.value = 0
    }
}