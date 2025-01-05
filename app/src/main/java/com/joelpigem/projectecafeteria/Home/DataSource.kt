package com.joelpigem.projectecafeteria.Home

import com.joelpigem.projectecafeteria.R

//class DataSource {
object DataSource {
    var productes: MutableList<MenuModel> = mutableListOf (
        MenuModel("menjar", R.drawable.baseline_lunch_dining_24, "Hamburguesa", 1, 10),
        MenuModel("menjar", R.drawable.baseline_dinner_dining_24, "Espaguetis", 1, 8),
        MenuModel("menjar", R.drawable.baseline_ramen_dining_24, "Ramen", 1, 7),
        MenuModel("menjar", R.drawable.baseline_kebab_dining_24, "Kebab", 1, 6),
        MenuModel("beguda", R.drawable.baseline_local_drink_24, "Aigua", 1, 2),
        MenuModel("beguda", R.drawable.baseline_local_drink_24, "CocaCola", 1, 3),
        MenuModel("beguda", R.drawable.baseline_local_drink_24, "Aquarius", 1, 3),
        MenuModel("beguda", R.drawable.baseline_local_drink_24, "Neste", 1, 3),
        MenuModel("postres", R.drawable.baseline_cake_24, "Pastis de Formatge", 1, 4),
        MenuModel("postres", R.drawable.baseline_bakery_dining_24, "Croasant", 1, 2),
        MenuModel("postres", R.drawable.baseline_free_breakfast_24, "Cafe", 1, 2),
        MenuModel("postres", R.drawable.baseline_brunch_dining_24, "Coques amb batut de xocolata", 1, 2)
    )


    fun carregarProductes(): MutableList<MenuModel> {
        return productes
    }
}

