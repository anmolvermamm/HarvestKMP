package ui.screens.loginScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginContainerTextField(
    value: String,
    onValueChange: (String) -> Unit,
    isPasswordField: Boolean = false,
    placeholderText: String,
    shape: Shape,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholderText) },
        visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.onSurface,
            unfocusedBorderColor = borderColor.copy(alpha = 0.25f),
            backgroundColor = MaterialTheme.colors.surface,
            cursorColor = MaterialTheme.colors.onSurface,
        ),
        shape = shape,
    )
}