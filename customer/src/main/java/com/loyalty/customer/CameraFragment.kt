package com.loyalty.customer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.DecoratedBarcodeView

/* todo: refactor this test class */
class CameraFragment: Fragment() {

    private var barcodeView: DecoratedBarcodeView? = null

    companion object {
        fun newInstance(): CameraFragment {
            return CameraFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_scanner, container, false)
        barcodeView = rootView.findViewById(R.id.barcode_view)
        barcodeView?.decodeSingle(object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult?) {
                Log.d("myLog", result?.text)
            }
            override fun possibleResultPoints(resultPoints: MutableList<ResultPoint>?) {
                Log.d("myLog", "smth")
            }
        })

        return rootView
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (barcodeView != null) {
            if (isVisibleToUser) {
                barcodeView!!.resume()
            } else {
                barcodeView!!.pauseAndWait()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        barcodeView!!.pauseAndWait()
    }

    override fun onResume() {
        super.onResume()
        barcodeView!!.resume()
    }
}