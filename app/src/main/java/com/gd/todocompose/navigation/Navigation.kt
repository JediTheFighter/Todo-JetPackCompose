package com.gd.todocompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.gd.todocompose.navigation.destinations.listComposable
import com.gd.todocompose.navigation.destinations.splashComposable
import com.gd.todocompose.navigation.destinations.taskComposable
import com.gd.todocompose.ui.viewmodels.SharedViewModel
import com.gd.todocompose.util.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetUpNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN,
        builder = {
            splashComposable(
                navigateToListScreen = screen.splash,
            )
            listComposable(
                navigateToTaskScreen = screen.list,
                sharedViewModel = sharedViewModel
            )
            taskComposable(
                navigateToListScreen = screen.task,
                sharedViewModel = sharedViewModel
            )
        }
    )
}