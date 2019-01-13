package com.loyalty.core.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.loyalty.core.R
import kotlinx.android.synthetic.main.stepper.view.stepperNegative
import kotlinx.android.synthetic.main.stepper.view.stepperNumber
import kotlinx.android.synthetic.main.stepper.view.stepperPositive

class NumberStepper @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var stepValue: Int = 0
        private set

    var maxValue: Int? = null
    var minValue: Int? = null

    init {
        View.inflate(context, R.layout.stepper, this)

        context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.NumberStepper,
                0, 0
        ).apply {
            try {
                stepValue = getInteger(R.styleable.NumberStepper_initialStepValue, 0)
            } finally {
                recycle()
                setStepperListeners()
                updateStepperNumber()
            }
        }
    }

    private fun setStepperListeners() {
        stepperNegative.setOnClickListener(null)
        stepperNegative.setOnClickListener { _ ->
            if (minValue == null) {
                decreaseStepValue()
            } else {
                minValue?.let {
                    if (stepValue > it) {
                        decreaseStepValue()
                    }
                }
            }
        }
        stepperPositive.setOnClickListener(null)
        stepperPositive.setOnClickListener { _ ->
            if (maxValue == null) {
                increaseStepValue()
            } else {
                maxValue?.let {
                    if (stepValue < it) {
                        increaseStepValue()
                    }
                }
            }
        }
    }

    private fun increaseStepValue() {
        stepValue++
        updateStepperNumber()
    }

    private fun decreaseStepValue() {
        stepValue--
        updateStepperNumber()
    }

    private fun updateStepperNumber() {
        stepperNumber.post {
            stepperNumber.text = stepValue.toString()
            invalidate()
            requestLayout()
        }
    }

}