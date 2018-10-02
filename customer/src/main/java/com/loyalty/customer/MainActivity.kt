package com.loyalty.customer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log

import com.loyalty.core.keystore.EncryptorImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import android.graphics.Bitmap
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeEncoder
import permissions.dispatcher.*
import android.R.attr.data
import android.widget.Toast
import com.google.zxing.integration.android.IntentResult

/* todo refactor this activity */
@RuntimePermissions
class MainActivity : AppCompatActivity() {

    val fragment = CameraFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        generateQrCode()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commitNow()
        }

        findViewById<Button>(R.id.btnActivateCamera).setOnClickListener {
//            showCamera()
            startCameraStream()
        }
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

    @NeedsPermission(Manifest.permission.CAMERA)
    fun startCameraStream() {

    }

    @NeedsPermission(Manifest.permission.CAMERA)
    fun showCamera() {
        val intentIntegrator = IntentIntegrator.forSupportFragment(fragment)
        intentIntegrator.apply {
            setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            setBeepEnabled(false)
            setOrientationLocked(false)
        }
        intentIntegrator.initiateScan()
    }

    @OnShowRationale(Manifest.permission.CAMERA)
    fun showRationaleForCamera() {

    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    fun onCameraDenied() {

    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    fun onCameraNeverAskAgain() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }

    //    private fun generateQrCode() {
//        val barcodeEncoder = BarcodeEncoder()
//        val bitmap = barcodeEncoder.encodeBitmap("content", BarcodeFormat.QR_CODE, 400, 400)
//        val imageViewQrCode = findViewById<ImageView>(R.id.qrCode)
//        imageViewQrCode.setImageBitmap(bitmap)
//    }
}
