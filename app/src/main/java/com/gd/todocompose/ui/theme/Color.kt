package com.gd.todocompose.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val LightGrey = Color(0xFFFCFCFC)
val MediumGrey = Color(0xFF9C9C9C)
val DarkGrey = Color(0xFF141414)

val LowPriorityColor = Color(0xFF42D549)
val MediumPriorityColor = Color(0xFFF0D54A)
val HighPriorityColor = Color(0xFFC62828)
val NormalPriorityColor = Color(0xFFFFFFFF)
val NonePriorityColor = MediumGrey

val Colors.splashScreenBackground: Color
@Composable
get() = if(isLight) Purple700 else Color.Black

val Colors.taskItemTextColor: Color
@Composable
get() = if(isLight) DarkGrey else LightGrey

val Colors.taskItemBackgroundColor: Color
@Composable
get() = if(isLight) Color.White else DarkGrey

val Colors.topAppBarContentColor: Color
@Composable
get() = if(isLight) Color.White else LightGrey

val Colors.topAppBarBackgroundColor: Color
@Composable
get() = if(isLight) Purple500 else Color.Black

val Colors.fabBackgroundColor: Color
@Composable
get() = if(isLight) Teal200 else Purple700

