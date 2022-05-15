package ui.screens.loginScreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import ui.theme.LoginScreenTypography

@Composable
fun LoginContainerDivider() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
    ) {
        val dividerWidthFactor by remember { mutableStateOf(0.3f) }
        Divider(
            modifier = Modifier.fillMaxWidth(dividerWidthFactor)
                .align(Alignment.CenterStart),
            color = borderColor,
            thickness = borderThickness
        )
        Divider(
            modifier = Modifier.fillMaxWidth(dividerWidthFactor).align(Alignment.CenterEnd),
            color = borderColor,
            thickness = borderThickness
        )
        Text(
            "or with your email below",
            modifier = Modifier.alpha(borderAlpha),
            style = LoginScreenTypography.body2
        )
    }
}