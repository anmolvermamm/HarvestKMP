package ui.screens.loginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ui.navigation.NavController
import ui.screens.loginScreen.components.InfoContainer
import ui.screens.loginScreen.components.LoginContainer
import ui.screens.loginScreen.components.OtherActionsRow
import ui.theme.DrawableResources
import ui.theme.LoginPageColors
import ui.theme.LoginScreenTypography

@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .requiredWidthIn(
                    max = 500.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(DrawableResources.HarvestLabelLogo),
                null,
                modifier = Modifier
                    .width(150.dp)
                    .padding(top = 16.dp)
            )

            Spacer(Modifier.padding(top = 75.dp))

            Text(
                "Sign in to Harvest",
                style = LoginScreenTypography.h4,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            InfoContainer(
                visible = false,
                icon = Icons.Default.Check,
                tint = LoginPageColors.SignInBtnBgColor,
                label = "You have been signed out."
            )

            LoginContainer(navController = navController)

            OtherActionsRow()
        }
    }
}
