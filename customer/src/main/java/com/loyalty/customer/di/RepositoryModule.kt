package com.loyalty.customer.di

import com.loyalty.customer.repository.venuepage.FakeVenuePageRepository
import com.loyalty.customer.repository.venuepage.VenuePageRepository
import com.loyalty.customer.repository.venues.FakeVenuesRepository
import com.loyalty.customer.repository.venues.VenuesRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    factory<VenuesRepository> {
        FakeVenuesRepository()
    }
    factory<VenuePageRepository> {
        FakeVenuePageRepository()
    }
}