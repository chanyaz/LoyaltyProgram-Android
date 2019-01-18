package com.loyalty.vendor.presentation.scan.bottomsheet

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.view.OnBottomSheetDismissListener
import com.loyalty.core.presentation.mvvm.BottomSheetMvvmFragment
import com.loyalty.vendor.R
import com.loyalty.vendor.ui.models.CustomerSheetUIModel
import kotlinx.android.synthetic.main.scan_sheet.scanConfirmButton
import kotlinx.android.synthetic.main.scan_sheet.scanCustomerImage
import kotlinx.android.synthetic.main.scan_sheet.scanCustomerName
import kotlinx.android.synthetic.main.scan_sheet.scanNumberStepper
import org.koin.android.viewmodel.ext.android.viewModel

class ScanSheetFragment : BottomSheetMvvmFragment<ScanSheetState, BaseEvent>() {

    override val layout: Int get() = R.layout.scan_sheet

    override val viewModel: ScanSheetViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initViewModel(arguments?.getParcelable(KEY_CUSTOMER))

        initViews()
    }

    private fun initViews() {
        scanConfirmButton.setOnClickListener {
            Toast.makeText(activity, "test", Toast.LENGTH_SHORT).show()
        }
    }

    override fun renderState(state: ScanSheetState) {
        super.renderState(state)
        if (state.customer == null) {
            renderEmptyState()
        } else if (state.customer != null) {
            renderLoadedState(state.customer)
        } else {
            throw UnexpectedStateException(state.toString())
        }
    }

    private fun renderEmptyState() {
        /* TODO() */
    }

    private fun renderLoadedState(customer: CustomerSheetUIModel) {
        Glide.with(scanCustomerImage).load(customer.imageUrl).into(scanCustomerImage)
        scanCustomerName.text = customer.name
        scanNumberStepper.apply {
            stepValue = customer.points
            minValue = customer.points
        }
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        (parentFragment as? OnBottomSheetDismissListener)?.onBottomSheetDismiss()
    }

    companion object {
        private const val KEY_CUSTOMER = "KEY_CUSTOMER"

        fun newInstance(customer: CustomerSheetUIModel): ScanSheetFragment =
                ScanSheetFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(KEY_CUSTOMER, customer)
                    }
                }
    }

}