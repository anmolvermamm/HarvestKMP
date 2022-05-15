package ui.screens.landingScreen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import ui.navigation.NavController
import ui.screens.landingScreen.components.LandingScreenAppBar
import ui.screens.landingScreen.components.ProfilePopup

enum class LandingScreenOptions(val content: @Composable () -> Unit = {}) {
    Overview(content = { Text("Overview Screen") }),
    Time(content = { Text("Time Screen") }),
    Projects(content = { Text("Projects Screen") }),
    Reports(content = { Text("Reports Screen") })
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LandingScreen(navController: NavController) {
    val appBarForegroundColor = MaterialTheme.colors.surface
    var currentSelectedScreen by remember { mutableStateOf(LandingScreenOptions.Overview) }
    var isProfilePopupVisible by remember { mutableStateOf(false) }
    var screenWidth by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            LandingScreenAppBar(
                currentSelectedScreen = currentSelectedScreen,
                appBarForegroundColor = appBarForegroundColor,
                showProfilePopup = { isProfilePopupVisible = true },
                onScreenChange = { currentScreen -> currentSelectedScreen = currentScreen },
            )
        }
    ) { bodyPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .onSizeChanged { screenSize ->
                screenWidth = screenSize.width
            }
            .padding(bodyPadding)
        ) {
            AnimatedContent(targetState = currentSelectedScreen) { selectedScreen ->
                selectedScreen.content()
            }
        }
        ProfilePopup(
            isProfilePopupVisible = isProfilePopupVisible,
            onDismissRequest = { isProfilePopupVisible = false },
            screenWidth = screenWidth,
            navController = navController,
        )
    }
}
