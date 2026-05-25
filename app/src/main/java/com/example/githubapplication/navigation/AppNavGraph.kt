package com.example.githubapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.githubapplication.ui.repodetail.RepoDetailScreen
import com.example.githubapplication.ui.repos.UserReposScreen

private const val ROUTE_REPOS = "repos"
private const val ROUTE_REPO_DETAIL = "repo_detail/{repoName}"
private const val ARG_REPO_NAME = "repoName"

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ROUTE_REPOS) {

        composable(ROUTE_REPOS) {
            UserReposScreen(
                onNavigateToRepoDetail = { repoName ->
                    navController.navigate("repo_detail/$repoName")
                }
            )
        }

        composable(
            route = ROUTE_REPO_DETAIL,
            arguments = listOf(navArgument(ARG_REPO_NAME) { type = NavType.StringType })
        ) {
            RepoDetailScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}
