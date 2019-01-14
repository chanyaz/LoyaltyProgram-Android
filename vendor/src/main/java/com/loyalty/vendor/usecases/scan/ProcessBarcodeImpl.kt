package com.loyalty.vendor.usecases.scan

import com.journeyapps.barcodescanner.BarcodeResult
import com.loyalty.vendor.ui.models.CustomerSheetUIModel
import io.reactivex.Single

class ProcessBarcodeImpl : ProcessBarcode {

    override fun invoke(barcodeResult: BarcodeResult): Single<CustomerSheetUIModel> =
            Single.just(CustomerSheetUIModel(
                    name = "Сергей Мавроди",
                    imageUrl = "http://www.fab.ng/wp-content/uploads/2018/03/mmm.jpg",
                    points = 42
            ))

}