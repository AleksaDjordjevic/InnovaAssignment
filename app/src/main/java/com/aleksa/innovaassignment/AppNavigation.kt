package com.aleksa.innovaassignment

class AppNavigation {
    enum class Screen {
        UserRepositories,
        RepositoryDetails,

    }

    sealed class NavigationItem(val route: String) {
        data object RepositoriesScreen : NavigationItem(Screen.UserRepositories.name)
        data object RepositoryDetailScreen : NavigationItem(Screen.RepositoryDetails.name)

    }
}