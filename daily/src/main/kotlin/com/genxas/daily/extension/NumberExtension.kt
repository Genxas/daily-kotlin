package com.genxas.daily.extension

import java.text.NumberFormat
import java.util.*

fun Double.thousands(): String = NumberFormat.getNumberInstance(Locale.US).format(this)