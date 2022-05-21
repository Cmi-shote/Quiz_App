package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0

    private var mUsername : String? = null
    private var mCorrectAns : Int = 0

    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var imageView: ImageView? = null

    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null

    private var btnSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUsername = intent.getStringExtra(Constants.UserName)


        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        imageView = findViewById(R.id.image)
        tvOption1 = findViewById(R.id.tv_option1)
        tvOption2 = findViewById(R.id.tv_option2)
        tvOption3 = findViewById(R.id.tv_option3)
        tvOption4 = findViewById(R.id.tv_option4)
        btnSubmit = findViewById(R.id.submitButton)


        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()
        defaultOptionView()

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionView()

        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        imageView?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "${mCurrentPosition}/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour



        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "Finish"
        }
        else{
            btnSubmit?.text = "Submit"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOption1?.let{
            options.add(it)
        }

        tvOption2?.let{
            options.add(it)
        }

        tvOption3?.let{
            options.add(it)
        }

        tvOption4?.let{
            options.add(it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }
    }


    private fun selectedOptionView(tv:TextView, selectedOptionNum : Int){
        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option1 -> {
                tvOption1?.let{
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_option2 -> {
                tvOption2?.let{
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_option3 -> {
                tvOption3?.let{
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_option4 -> {
                tvOption4?.let{
                    selectedOptionView(it, 4)
                }
            }

            R.id.submitButton -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.UserName, mUsername)
                            intent.putExtra(Constants.CorrectAnswers, mCorrectAns)
                            intent.putExtra(Constants.TotalQuestions, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAns != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else {
                        mCorrectAns++
                    }
                    answerView(question.correctAns, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text = "Finish"
                    }else{
                        btnSubmit?.text = "Go To Next Question"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(ans: Int, drawableView: Int){
        when(ans){
            1 -> {
                tvOption1?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            2 -> {
                tvOption2?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            3 -> {
                tvOption3?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            4 -> {
                tvOption4?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}