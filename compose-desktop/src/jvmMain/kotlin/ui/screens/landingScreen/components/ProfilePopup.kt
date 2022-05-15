package ui.screens.landingScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import ui.navigation.NavController
import ui.theme.LandingScreenTypography
import ui.theme.TextResources

private val AppBarHeight = 56.dp

@Composable
fun ProfilePopup(
    isProfilePopupVisible: Boolean,
    onDismissRequest: () -> Unit,
    screenWidth: Int,
    navController: NavController,
) {
    val density = LocalDensity.current
    DropdownMenu(
        expanded = isProfilePopupVisible,
        onDismissRequest = onDismissRequest,
        focusable = true,
        offset = DpOffset(x = with(density) { screenWidth.toDp() - 175.dp }, y = AppBarHeight)
    )
    {
        Column(horizontalAlignment = Alignment.Start) {
            Column(modifier = Modifier.popupPadding(top = 6.dp, bottom = 14.dp)) {
                Text("Shubham Singh", style = LandingScreenTypography.h6)
                Text(
                    "Mutual Mobile, Inc",
                    style = LandingScreenTypography.subtitle2,
                    modifier = Modifier.alpha(0.75f)
                )
            }
            Divider()
            PopupContainer {
                PopupText(TextResources.PopupProfileItem)
                PopupText(TextResources.PopupTimeItem)
                PopupText(TextResources.PopupNotificationItem)
            }
            Divider()
            PopupContainer {
                PopupText(TextResources.PopupAppsItem)
                PopupText(TextResources.PopupIntegrationsItem)
                PopupText(TextResources.PopupTermsItem)
                PopupText(TextResources.PopupPrivacyPolicyItem)
            }
            Divider(modifier = Modifier.padding(bottom = 8.dp))
            PopupText(TextResources.PopupSignOutItem) { navController.navigateBack() }
        }
    }
}

@Composable
private fun PopupContainer(content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) { content() }
}

@Composable
private fun Modifier.popupPadding(
    start: Dp = 16.dp,
    end: Dp = 16.dp,
    top: Dp = 10.dp,
    bottom: Dp = 10.dp
) = this.padding(start = start, top = top, end = end, bottom = bottom)

@Composable
private fun PopupText(label: String, onClick: () -> Unit = {}) {
    Text(
        label,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .popupPadding(),
        style = LandingScreenTypography.body2
    )
}