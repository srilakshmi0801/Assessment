package com.example.assessment.screens.ui

interface Route {
    val route: String
}

object HomeScreenRoute: Route {
    override val route: String
        get() = "home_screen"
}

object DetailScreenRoute: Route {
    override val route: String
        get() = "details_screen"
}