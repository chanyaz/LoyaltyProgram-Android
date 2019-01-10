package com.loyalty.vendor.presentation.scan

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.vendor.R
import org.koin.android.ext.android.inject

class ScanFragment : MvvmFragment<ScanState, BaseEvent>() {

    override val layout: Int get() = R.layout.scan_fragment

    override val viewModel: ScanViewModel by inject()



    companion object {
        fun newInstance() : ScanFragment = ScanFragment()
    }

}