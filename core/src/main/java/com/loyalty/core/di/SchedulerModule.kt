package com.loyalty.core.di

import com.loyalty.core.BaseConsts
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module.module

val schedulerModule = module {
    factory<Scheduler>(name = BaseConsts.SCHEDULER_IO) { Schedulers.io() }
    factory<Scheduler>(name = BaseConsts.SCHEDULER_COMPUTATION) { Schedulers.computation() }
}