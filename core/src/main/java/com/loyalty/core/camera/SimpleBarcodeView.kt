package com.loyalty.core.camera

import android.content.Context
import android.util.AttributeSet
import com.journeyapps.barcodescanner.DecoratedBarcodeView
import com.loyalty.core.util.extensions.gone

class SimpleBarcodeView @JvmOverloads constructor(
        context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0
) : DecoratedBarcodeView(context, attributeSet, defStyleAttr) {

    init {
        viewFinder.gone()
        statusView.gone()
    }

}