package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.baseio.kmm.di.initSharedDependencies
import ui.navigation.Destinations
import ui.navigation.NavHost
import ui.navigation.composable
import ui.navigation.rememberNavController
import ui.screens.landingScreen.LandingScreen
import ui.screens.loginScreen.LoginScreen
import ui.theme.DrawableResources
import ui.theme.HarvestKmpTheme
import ui.theme.TextResources

@Composable
@Preview
fun App() {
    HarvestKmpTheme {
        val navController by rememberNavController(startDestination = Destinations.LoginScreen.route)
        NavHost(navController) {
            composable(Destinations.LoginScreen.route) {
                LoginScreen(navController = navController)
            }
            composable(Destinations.LandingScreen.route) {
                LandingScreen(navController = navController)
            }
        }.build()
    }
}

fun main() = application {
    initSharedDependencies()
    Window(
        onCloseRequest = ::exitApplication,
        title = TextResources.AppName,
        icon = painterResource(DrawableResources.HarvestLogo),
    ) {
        App()
    }
}
