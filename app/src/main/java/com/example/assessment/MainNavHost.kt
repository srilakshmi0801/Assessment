package com.example.assessment

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assessment.data.models.Image
import com.example.assessment.screens.ui.SearchComposable
import com.example.assessment.screens.ui.HomeScreenRoute
import com.example.assessment.screens.ui.DetailScreenRoute
import com.example.assessment.screens.ui.ImageDetailsComposable

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    modifier: Modifier,
    mainViewModel: MainViewModel
) {

    lateinit var image: Image

    NavHost(
        navController = navHostController,
        startDestination = HomeScreenRoute.route,
        modifier = Modifier
    ) {
        composable(route = HomeScreenRoute.route) {
            SearchComposable(
                mainViewModel,
                modifier,
                navigateToDetails = {
                    image = it
                    navHostController.navigate(DetailScreenRoute.route)
                }
            )
        }

        composable(route = DetailScreenRoute.route) {
            ImageDetailsComposable(
                searchResultImageData = mainViewModel.getTheImageDetailsObject(image)
            )
        }
    }

}