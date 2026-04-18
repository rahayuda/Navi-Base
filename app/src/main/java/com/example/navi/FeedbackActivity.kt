package com.example.navi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FeedbackActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_feedback)
        supportActionBar?.title = "Feedback"

        val editFeedback = findViewById<EditText>(R.id.editFeedback)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val txtResult = findViewById<TextView>(R.id.txtFeedbackResult)

        btnSubmit.setOnClickListener {
            val message = editFeedback.text.toString()
            if (message.isNotEmpty()) {
                txtResult.text = "Your Feedback:\n$message"
                editFeedback.text.clear()
            } else {
                txtResult.text = "Please enter your feedback first."
            }
        }
    }
}