package com.loyalty.core.util.extensions

import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

fun ImageView.processQr(qrString: String) {
    setImageBitmap(BarcodeEncoder().encodeBitmap(qrString, BarcodeFormat.QR_CODE, width, height))
}