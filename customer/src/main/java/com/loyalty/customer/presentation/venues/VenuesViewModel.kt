package com.loyalty.customer.presentation.venues

import com.loyalty.core.presentation.mvvm.BaseViewModel

class VenuesViewModel(

) : BaseViewModel<VenuesState, VenuesEvent>() {

    fun initViewModel() {
        setState(VenuesState.VenuesLoading)
    }

}