package com.example.dialogfragmentandbuilderpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogfragmentandbuilderpattern.databinding.ActivityMainBinding
import com.example.dialogfragmentandbuilderpattern.databinding.DialogBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binging: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)

        binging.button.setOnClickListener {
            // передача обязательных параметров, предварительная сборка объекта
            val alertDialogBuilder: AlertDialog.Builder  = AlertDialog.Builder(this)

            // передача дополнительных параметров, предварительная сборка объекта
            alertDialogBuilder.setTitle("Title")
            alertDialogBuilder.setMessage("Some message")


            val binding = DialogBinding.inflate(layoutInflater)
            val customView = binding.root

            // установка кастомного View в Builder
            alertDialogBuilder.setView(customView)
            alertDialogBuilder.setPositiveButton("Ok"){
                    dialog, which -> Toast.makeText(this, "Ok clicked", Toast.LENGTH_SHORT).show()
            }
            alertDialogBuilder.setNegativeButton("Cancel"){
                    dialog, which -> Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show()
            }

            // окончательная сборка объекта
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()

        }
    }
}