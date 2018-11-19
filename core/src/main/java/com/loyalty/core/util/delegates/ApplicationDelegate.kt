package com.loyalty.core.util.delegates

import android.app.Application
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ApplicationDelegate<in R, T: Application>: ReadWriteProperty<R, T> {

    private var application: T? = null

    override fun getValue(thisRef: R, property: KProperty<*>): T = application!!

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        if (application != null)
            throw RuntimeException("Application has already been initialized")

        application = value
    }
}