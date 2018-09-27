package com.loyalty.customer

import android.os.Bundle
import android.util.Log

import com.loyalty.core.keystore.EncryptorImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        generateQrCode()
//        EncryptorImpl(this, AndroidSchedulers.mainThread())
//                .decryptString("gKn1iHDsWr3Fw6RMkmbWSN4vbqU2mKnF+g6N3dlV84/P9fNAUDvq7x4PdpzMruDAwVmY79l8d/aP\n" +
//                        "sRIYGfTTIEaJFWuBts7TBBnGosycekLNP7aurn3zh7OU4f2K07ErX9vneG6UD9uA7lXUKEi1UhQy\n" +
//                        "jyZdb57nLJPYkvLBXDu/tx7ugIHj7MM5mlnoeKrxVQw6sIQKRmypfk55NT23ei3QHhm/R2Ati7q2\n" +
//                        "JpTnkH/tE87FG045CVtsNGySxCmOWOdONooDaJEIjvFDhIscEpNm/tfWDyn4l1BaboJYScuiddgj\n" +
//                        "eCwte9cbV1AkwLb8IqsdiKQttwKl80Lp2QpKug==")
//                .subscribe({
//                    Log.d("myLog", it)
//                }, {
//                    Log.d("myLog", it.message)
//                })
    }

//    private fun generateQrCode() {
//        val barcodeEncoder = BarcodeEncoder()
//        val bitmap = barcodeEncoder.encodeBitmap("content", BarcodeFormat.QR_CODE, 400, 400)
//        val imageViewQrCode = findViewById<ImageView>(R.id.qrCode)
//        imageViewQrCode.setImageBitmap(bitmap)
//    }
}
