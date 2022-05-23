package com.mutualmobile.harvestKmp.android.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val PrimaryColor = Color(0xFFF06808)
val PrimaryLightColor = Color(0xFFFF8F1E)
val SecondaryColor = Color(0xFF00B500)
val TertiaryColor = Color(0xFF0079CF)
val TertiaryInverseColor = Color(0xFF7BB0F8)
val DrawerBgColor = Color(0xFF323232)
val DrawerItemSelectedColor = Color(0xFF101010)
val SwitchCheckedTrackColor = Color(0xFFFFDEC8)
val SwitchUncheckedTrackColor = Color(0xFFB7B7B7)
val SwitchUncheckedThumbColor = Color(0xFFECECEC)
val SurfaceColor = Color(0xFFEFEFEF)
val WeekSwitchButtonBgColor = Color(0xFFD7D7D7)

val DarkBackgroundColor = Color(0xFF101010)
val LightBackgroundColor = Color(0xFFECECEC)

val Colors.backgroundColor: Color
  @Composable
  get() = if (isLight) LightBackgroundColor else DarkBackgroundColor

val DarkTextColor = Color(0xFFECECEC)
val LightTextColor = Color(0xFF101010)

val Colors.textColor: Color
  @Composable
  get() = if (isLight) LightTextColor else DarkTextColor

val DarkButtonColor = Color(0xFFECECEC)
val LightButtonColor = Color(0xFF101010)

val Colors.buttonColor: Color
  @Composable
  get() = if (isLight) LightButtonColor else DarkButtonColor

val DarkButtonTextColor = Color(0xFF101010)
val LightButtonTextColor = Color(0xFFECECEC)

val Colors.buttonTextColor: Color
  @Composable
  get() = if (isLight) LightButtonTextColor else DarkButtonTextColor