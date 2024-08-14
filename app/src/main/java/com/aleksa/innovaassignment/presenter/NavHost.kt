package com.aleksa.innovaassignment.presenter

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aleksa.innovaassignment.AppNavigation
import com.aleksa.innovaassignment.model.RepositoryItem
import com.aleksa.innovaassignment.presenter.screens.details.DetailsScreen
import com.aleksa.innovaassignment.presenter.screens.details.RepositoryDetailsViewModel
import com.aleksa.innovaassignment.presenter.screens.repositories.RepositoriesListViewModel
import com.aleksa.innovaassignment.presenter.screens.repositories.RepositoriesScreen
import com.aleksa.innovaassignment.util.Constants

@Composable
fun NavGraph(
    startDestination: String,
    navController: NavHostController,
    innerPadding: PaddingValues,
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.padding(paddingValues = innerPadding)
    ) {

        composable(
            route = AppNavigation.NavigationItem.RepositoriesScreen.route
        ) {
            val viewModel: RepositoriesListViewModel = hiltViewModel()
            RepositoriesScreen(
                repoList = viewModel.repositoryList.observeAsState().value,
                onRepoItemClick = { navigateToDetailsScreen(navController = navController, repositoryItem = it) }
            )
        }
        composable(
            route = AppNavigation.NavigationItem.RepositoryDetailScreen.route
        ) {
            navController.previousBackStackEntry?.savedStateHandle?.get<RepositoryItem?>(Constants.REPOSITORY_ITEM)
                ?.let {
                    val viewModel: RepositoryDetailsViewModel = hiltViewModel()
                    viewModel.getRepositoryTags(it.name)
                    DetailsScreen(repositoryItem = it, tagsList = viewModel.repositoryTagsList.observeAsState().value)
                }
        }
    }
}

private fun navigateToDetailsScreen(navController: NavController, repositoryItem: RepositoryItem) {
    navController.currentBackStackEntry?.savedStateHandle?.set(Constants.REPOSITORY_ITEM, repositoryItem)
    navController.navigate(
        route = AppNavigation.NavigationItem.RepositoryDetailScreen.route
    )
}