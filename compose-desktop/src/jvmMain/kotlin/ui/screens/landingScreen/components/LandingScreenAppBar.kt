package ui.screens.landingScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.screens.landingScreen.LandingScreenOptions
import ui.theme.HarvestRed
import ui.theme.TextResources

@Composable
fun LandingScreenAppBar(
    currentSelectedScreen: LandingScreenOptions,
    appBarForegroundColor: Color,
    showProfilePopup: () -> Unit,
    onScreenChange: (LandingScreenOptions) -> Unit,
) {
    TopAppBar(
        title = {
            Row {
                IconButton(
                    onClick = {
                        onScreenChange(LandingScreenOptions.Overview)
                    }, modifier = getSelectedModifier(
                        selected = currentSelectedScreen == LandingScreenOptions.Overview,
                        selectedColor = appBarForegroundColor
                    ).fillMaxHeight()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        contentDescription = LandingScreenOptions.Overview.name,
                        tint = appBarForegroundColor
                    )
                }
                ForegroundTextButton(
                    LandingScreenOptions.Time.name,
                    selected = currentSelectedScreen == LandingScreenOptions.Time
                ) {
                    onScreenChange(LandingScreenOptions.Time)
                }
                ForegroundTextButton(
                    LandingScreenOptions.Projects.name,
                    selected = currentSelectedScreen == LandingScreenOptions.Projects
                ) {
                    onScreenChange(LandingScreenOptions.Projects)
                }
                ForegroundTextButton(
                    LandingScreenOptions.Reports.name,
                    selected = currentSelectedScreen == LandingScreenOptions.Reports
                ) {
                    onScreenChange(LandingScreenOptions.Reports)
                }
            }
        },
        actions = {
            ForegroundTextButton(TextResources.LandingScreenAppBarHelpActionItem, selected = false)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .clickable(onClick = showProfilePopup)
                    .padding(horizontal = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(appBarForegroundColor)
                        .size(32.dp)
                        .padding(8.dp),
                )
                Text(
                    "Shubham",
                    color = appBarForegroundColor,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = null,
                    tint = appBarForegroundColor
                )
            }
        },
        backgroundColor = HarvestRed
    )
}

@Composable
fun ForegroundTextButton(
    label: String,
    color: Color = MaterialTheme.colors.surface,
    selected: Boolean,
    onClick: () -> Unit = {},
) {
    val modifier = getSelectedModifier(selected = selected, selectedColor = color)
    TextButton(onClick = onClick, modifier = modifier.fillMaxHeight()) {
        Text(label, color = color)
    }
}

@Composable
fun getSelectedModifier(selected: Boolean, selectedColor: Color): Modifier {
    return if (!selected) Modifier else Modifier.background(color = selectedColor.copy(alpha = 0.25f))
}