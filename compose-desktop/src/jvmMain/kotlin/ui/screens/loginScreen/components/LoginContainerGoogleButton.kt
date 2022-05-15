package ui.screens.loginScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ui.theme.DrawableResources
import ui.theme.LoginScreenTypography

@Composable
fun LoginContainerGoogleButton(borderColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
        border = BorderStroke(
            width = borderThickness,
            color = borderColor.copy(alpha = borderAlpha)
        ),
        shape = borderShape
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Image(painterResource(DrawableResources.GoogleLogo), null)
            Text(
                "Sign in with Google",
                modifier = Modifier.align(Alignment.Center),
                style = LoginScreenTypography.body1
            )
        }
    }
}