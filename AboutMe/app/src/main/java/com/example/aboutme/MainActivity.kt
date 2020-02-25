package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnDone).setOnClickListener { addNickname(it) }

        findViewById<TextView>(R.id.nickname_text).setOnClickListener{ updateNickname(it) }
    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTxtView = findViewById<TextView>(R.id.nickname_text)

        nicknameTxtView.text = editText.text

        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTxtView.visibility = View.VISIBLE

        val inputMM = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMM.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val btnDone = findViewById<Button>(R.id.btnDone)

        editText.visibility = View.VISIBLE
        btnDone.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}
