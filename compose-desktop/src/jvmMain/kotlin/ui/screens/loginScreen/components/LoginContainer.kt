package ui.screens.loginScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ui.navigation.Destinations
import ui.navigation.NavController
import ui.theme.LoginPageColors

const val borderAlpha: Float = 0.75f
val borderColor: Color @Composable get() = MaterialTheme.colors.onSurface.copy(alpha = borderAlpha)
val borderThickness: Dp = 0.5.dp
val borderCornerSize: Dp = 8.dp
val textFieldCornerSize: Dp = 4.dp
val borderShape = RoundedCornerShape(borderCornerSize)
val textFieldShape = RoundedCornerShape(textFieldCornerSize)

@Composable
fun LoginContainer(navController: NavController) {
    var loginEmail by remember { mutableStateOf("") }
    var loginPassword by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize().padding(vertical = 32.dp),
        border = BorderStroke(1.dp, color = LoginPageColors.TFContainerBorderColor),
        color = LoginPageColors.TFContainerColor,
        elevation = 0.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            LoginContainerGoogleButton(borderColor) {
                navController.navigate(Destinations.LandingScreen.route)
            }

            LoginContainerDivider()

            LoginContainerTextField(
                placeholderText = "Work email",
                value = loginEmail,
                onValueChange = { updatedText -> loginEmail = updatedText },
                shape = textFieldShape
            )

            LoginContainerTextField(
                isPasswordField = true,
                placeholderText = "Password",
                value = loginPassword,
                onValueChange = { updatedText -> loginPassword = updatedText },
                shape = textFieldShape
            )

            Button(
                onClick = {
                    navController.navigate(Destinations.LandingScreen.route)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LoginPageColors.SignInBtnBgColor
                ),
                shape = borderShape,
                modifier = Modifier.fillMaxWidth(),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
            ) {
                Text(
                    text = "Sign in",
                    color = MaterialTheme.colors.surface,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
        }
    }
}