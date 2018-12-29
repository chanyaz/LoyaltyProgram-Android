package com.loyalty.core.util.extensions

import kotlin.reflect.KMutableProperty0

fun KMutableProperty0<Boolean>.flip() = set(!get())
