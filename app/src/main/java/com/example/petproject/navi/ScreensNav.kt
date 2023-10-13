package com.example.petproject.navi

sealed class Screens(val route: String) {
    object First : Screens(route = "first_screen")
    object Region : Screens(route = "Region_screen")

}
