package com.loyalty.core.presentation.navigation.subnavigation

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import java.util.HashMap

class LocalCiceroneHolder {

    private val containers: HashMap<String, Cicerone<Router>> = HashMap()

    fun getCiceroneByTag(containerTag: String): Cicerone<Router> {
        if (!containers.containsKey(containerTag)) {
            containers[containerTag] = Cicerone.create()
        }
        /* It's guaranteed to be not null */
        return containers[containerTag]!!
    }

}
