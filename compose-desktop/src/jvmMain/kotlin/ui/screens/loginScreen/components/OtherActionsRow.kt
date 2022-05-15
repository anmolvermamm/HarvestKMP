package ui.screens.loginScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIconDefaults
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import ui.theme.LoginPageColors

@Composable
fun OtherActionsRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        OtherActionItem(label = "Forgot password?", onClick = {})
        OtherActionItem(label = "Terms of service", onClick = {})
        OtherActionItem(label = "Privacy policy", onClick = {})
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OtherActionItem(label: String, onClick: () -> Unit) {
    var isFocused by remember { mutableStateOf(false) }
    Text(
        buildAnnotatedString {
            withStyle(SpanStyle(textDecoration = if (isFocused) TextDecoration.Underline else null)) {
                append(label)
            }
        },
        color = LoginPageColors.OtherItemColor,
        modifier = Modifier
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
            .pointerHoverIcon(
                icon = PointerIconDefaults.Hand,
                overrideDescendants = true
            )
            .pointerMoveFilter(
                onEnter = {
                    isFocused = true
                    false
                },
                onExit = {
                    isFocused = false
                    false
                }
            ),
        style = MaterialTheme.typography.body2,
    )
}
