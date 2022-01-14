package com.gd.todocompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.gd.todocompose.ui.screens.list.ListScreen
import com.gd.todocompose.ui.viewmodels.SharedViewModel
import com.gd.todocompose.util.Action
import com.gd.todocompose.util.Constants.LIST_ARGUMENT_KEY
import com.gd.todocompose.util.Constants.LIST_SCREEN
import com.gd.todocompose.util.toAction

@ExperimentalAnimationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        val myAction = rememberSaveable() { mutableStateOf(Action.NO_ACTION) } /// prevent duplication during config changes.

        LaunchedEffect(key1 = myAction) {
            if(action != myAction.value) {  /// prevent duplication during config changes.
                myAction.value = action
                sharedViewModel.action.value = action
            }
        }

        val databaseAction by sharedViewModel.action

        ListScreen(
            action = databaseAction,
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}