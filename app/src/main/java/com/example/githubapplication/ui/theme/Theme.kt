package com.example.githubapplication.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val GitHubPrimary = Color(0xFF24292F)
private val GitHubOnPrimary = Color(0xFFFFFFFF)
private val GitHubSecondary = Color(0xFF0969DA)

private val LightColorScheme = lightColorScheme(
    primary = GitHubPrimary,
    onPrimary = GitHubOnPrimary,
    secondary = GitHubSecondary,
)

@Composable
fun GitHubAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content,
    )
}
