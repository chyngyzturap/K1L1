package com.pharos.k1l1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.pharos.k1l1.SecondActivity.Companion.TEXT_KEY2

class MainActivity : AppCompatActivity() {

    companion object {
        const val TEXT_KEY = "text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editTextMain = findViewById<EditText>(R.id.edit_text_main)
        val btnMain = findViewById<Button>(R.id.btn_main)
        var tvMain = findViewById<TextView>(R.id.tv_main)

        val textFromIntent = intent.getStringExtra(TEXT_KEY2).toString()
        tvMain.setText(textFromIntent)

        btnMain.setOnClickListener {
            var editText: String = editTextMain.text.toString()
            if (editText.trim().length > 0) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(TEXT_KEY, editText)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Edit Text can't be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}