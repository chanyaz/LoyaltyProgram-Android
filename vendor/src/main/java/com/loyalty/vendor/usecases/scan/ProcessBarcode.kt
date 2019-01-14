package com.loyalty.vendor.usecases.scan

import com.journeyapps.barcodescanner.BarcodeResult
import com.loyalty.vendor.ui.models.CustomerSheetUIModel
import io.reactivex.Single

interface ProcessBarcode {

    operator fun invoke(barcodeResult: BarcodeResult): Single<CustomerSheetUIModel>

}