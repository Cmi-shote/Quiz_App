package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName : TextView = findViewById(R.id.tv_name)
        val tvScore : TextView = findViewById(R.id.tv_score)
        val finishBtn : Button = findViewById(R.id.btnFinish)

        tvName.text = intent.getStringExtra(Constants.UserName)

        val totalQuestion = intent.getIntExtra(Constants.TotalQuestions, 0)
        val correctAnswer = intent.getIntExtra(Constants.CorrectAnswers, 0)

        tvScore.text = "Your score is $correctAnswer out of $totalQuestion"

        finishBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}