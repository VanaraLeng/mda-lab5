package com.vanaraleng.lab3

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitButton.setOnClickListener {
            val result = getResult()
            showResultDialog(result)
        }

        resetButton.setOnClickListener {
            radioGroup.clearCheck()

            listOf(checkBox1, checkBox2, checkBox3, checkBox4).forEach {
                it.isChecked = false
            }

        }
    }

    private fun getResult() : Int {
        val resultQ1 = if (radioGroup.checkedRadioButtonId == R.id.radioButton3) 50 else 0
        val resultQ2 = if (!checkBox1.isChecked && !checkBox2.isChecked && checkBox3.isChecked && !checkBox4.isChecked) 50 else 0
        return resultQ1 + resultQ2
    }

    private fun showResultDialog(point: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Result submit")
        builder.setNeutralButton("OK", null)

        val dateFormat = SimpleDateFormat()
        val dateString = dateFormat.format(Date())
        builder.setMessage("Congratulations! You submit on the $dateString, you achieved $point%")
        builder.create().show()
    }


}
