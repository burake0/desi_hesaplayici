@file:Suppress("DEPRECATION")

package com.example.desihesaplama

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var thicknessEditText: EditText
    private lateinit var widthEditText: EditText
    private lateinit var priceEditText: EditText
    private lateinit var heightEditText: EditText

    private var result: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        thicknessEditText = findViewById(R.id.thickness)
        widthEditText = findViewById(R.id.width)
        priceEditText = findViewById(R.id.price)
        heightEditText = findViewById(R.id.height)
        val desiHesapla = findViewById<Button>(R.id.button2)
        val priceHesapla = findViewById<Button>(R.id.button)

        desiHesapla.setOnClickListener {
            val thickness = thicknessEditText.text.toString().toIntOrNull() ?: 0
            val width = widthEditText.text.toString().toIntOrNull() ?: 0
            val height = heightEditText.text.toString().toIntOrNull() ?: 0
            val desiHeader = "Desi Sonucu"

            result = (thickness * width * height)
            showAlertDialog(desiHeader, result)
        }

        priceHesapla.setOnClickListener {
            val price = priceEditText.text.toString().toIntOrNull() ?: 0
            val priceResult = result * price
            val priceHeader = "Fiyat Sonucu"
            showAlertDialog(priceHeader, priceResult)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun showAlertDialog(h1: String, s1: Int) {
        val dialogBuilder = MaterialAlertDialogBuilder(this)
        dialogBuilder.setTitle(h1)
        dialogBuilder.setMessage("Desi Hesaplamanız: $s1")
            .setPositiveButton("Tamam") { _, _ ->

            }
            .setCancelable(false)
        val dialog = dialogBuilder.create()
        dialog.setOnShowListener {
            val positiveButton = (dialog as AlertDialog).getButton(DialogInterface.BUTTON_POSITIVE)
            positiveButton.setTextColor(ContextCompat.getColor(this, R.color.white)) // Beyaz metin rengi
            positiveButton.setBackgroundColor(ContextCompat.getColor(this, R.color.black)) // Siyah arka plan rengi
        }
        dialog.show()

        val customBackgroundDrawable = resources.getDrawable(R.drawable.custom_dialog_design)
        dialog.window?.setBackgroundDrawable(customBackgroundDrawable)
    }
}