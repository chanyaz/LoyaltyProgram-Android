package com.loyalty.customer.di

import com.loyalty.core.BaseConsts
import com.loyalty.customer.usecases.cards.LoadCards
import com.loyalty.customer.usecases.cards.LoadCardsImpl
import com.loyalty.customer.usecases.qr.LoadQrBitmapCase
import com.loyalty.customer.usecases.qr.LoadQrBitmapCaseImpl
import com.loyalty.customer.usecases.qr.LoadQrStringCase
import com.loyalty.customer.usecases.qr.LoadQrStringCaseImpl
import com.loyalty.customer.usecases.qr.StringToQrBitmapCase
import com.loyalty.customer.usecases.qr.StringToQrBitmapCaseImpl
import com.loyalty.customer.usecases.venue.LoadVenuePage
import com.loyalty.customer.usecases.venue.LoadVenuePageImpl
import com.loyalty.customer.usecases.venues.FilterVenues
import com.loyalty.customer.usecases.venues.FilterVenuesImpl
import com.loyalty.customer.usecases.venues.LoadVenues
import com.loyalty.customer.usecases.venues.LoadVenuesImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val useCasesModule = module {

    /* Qr */

    factory<LoadQrStringCase> { LoadQrStringCaseImpl(get()) }
    factory<StringToQrBitmapCase> { StringToQrBitmapCaseImpl(get(name = BaseConsts.SCHEDULER_COMPUTATION)) }
    factory<LoadQrBitmapCase> { LoadQrBitmapCaseImpl(get(), get(), androidApplication()) }

    /* Venues */

    factory<FilterVenues> { FilterVenuesImpl(get(name = BaseConsts.SCHEDULER_COMPUTATION)) }
    factory<LoadVenues> { LoadVenuesImpl(get(), get()) }

    /* Venue */

    factory<LoadVenuePage> { LoadVenuePageImpl(get()) }

    /* Cards */

    factory<LoadCards> { LoadCardsImpl(get(), get()) }

}