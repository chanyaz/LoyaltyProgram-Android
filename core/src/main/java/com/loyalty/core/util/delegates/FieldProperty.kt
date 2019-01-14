package com.loyalty.core.util.delegates

import kotlin.reflect.KProperty

class FieldProperty<R, T : Any>(
        val initializer: (R) -> T = { throw IllegalStateException("Not initialized.") }
) {
    private val map = HashMap<R, T>()

    operator fun getValue(thisRef: R, property: KProperty<*>): T =
            map[thisRef] ?: setValue(thisRef, property, initializer(thisRef))

    operator fun setValue(thisRef: R, property: KProperty<*>, value: T): T {
        map[thisRef] = value
        return value
    }

}