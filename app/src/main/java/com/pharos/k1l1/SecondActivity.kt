package com.pharos.k1l1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.pharos.k1l1.MainActivity.Companion.TEXT_KEY

class SecondActivity : AppCompatActivity() {
    
    companion object {
        const val TEXT_KEY2 = "text2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var editTextSecond = findViewById<EditText>(R.id.edit_text_second)
        val btnSecond = findViewById<Button>(R.id.btn_second)
        var tvSecond = findViewById<TextView>(R.id.tv_second)

        val textFromIntent = intent.getStringExtra(TEXT_KEY).toString()
        tvSecond.setText(textFromIntent)

        btnSecond.setOnClickListener {
            var editText2: String = editTextSecond.text.toString()
            if (editText2.trim().length > 0) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(TEXT_KEY2, editText2)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Edit Text can't be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}