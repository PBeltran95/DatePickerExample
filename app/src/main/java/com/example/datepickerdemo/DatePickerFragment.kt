package com.example.datepickerdemo

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment(
    private val listener: (day: Int, month: Int, year: Int) -> Unit
) : DialogFragment(), DatePickerDialog.OnDateSetListener {


    override fun onDateSet(p0: DatePicker?, day: Int, month: Int, year: Int) {
        listener(day, month, year)
    }

    override fun onCreateDialog(args: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        val picker = DatePickerDialog(activity as Context,R.style.datePickerFragment, this, year, month, day)
        picker.datePicker.maxDate = calendar.timeInMillis
        picker.datePicker.minDate = (calendar.timeInMillis - 10000000000L)
        return picker
    }

}