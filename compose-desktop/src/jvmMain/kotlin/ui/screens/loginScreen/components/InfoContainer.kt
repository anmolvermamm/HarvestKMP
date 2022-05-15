package ui.screens.loginScreen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import ui.theme.LoginPageColors

@Composable
fun InfoContainer(
    visible: Boolean,
    icon: ImageVector,
    tint: Color,
    label: String
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideInVertically(),
        exit = fadeOut() + slideOutVertically()
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp, color = LoginPageColors.InfoContainerBorderColor),
            color = LoginPageColors.InfoContainerBgColor,
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = tint,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Text(label)
                }
                Text(buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = LoginPageColors.LinkBlueColor,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Dismiss")
                    }
                }, modifier = Modifier.clickable(onClick = {}))
            }
        }
    }
}