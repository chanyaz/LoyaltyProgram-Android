package com.loyalty.vendor.usecases.scan

import com.journeyapps.barcodescanner.BarcodeResult
import com.loyalty.vendor.ui.models.CustomerSheetUIModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ProcessBarcodeImpl : ProcessBarcode {

    override fun invoke(barcodeResult: BarcodeResult): Single<CustomerSheetUIModel> =
            Single.just(CustomerSheetUIModel(
                    name = "Сергей Мавроди",
                    imageUrl = "http://www.fab.ng/wp-content/uploads/2018/03/mmm.jpg",
                    points = 42
            ))
                    .delay(300, TimeUnit.MILLISECONDS, Schedulers.io())

}