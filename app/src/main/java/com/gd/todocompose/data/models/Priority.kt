package com.gd.todocompose.data.models

import androidx.compose.ui.graphics.Color
import com.gd.todocompose.ui.theme.*

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}