package br.com.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.quizapp.Constants.CORRECT_ANSWER
import br.com.quizapp.Constants.TOTAL_QUESTIONS
import br.com.quizapp.Constants.USER_NAME
import br.com.quizapp.Constants.getQuestions
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mCorrectAnswer: Int = 0
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(USER_NAME)

        mQuestionList = getQuestions()

        setQuestion()

        textView_optionOne_id.setOnClickListener(this)
        textView_optionTwo_id.setOnClickListener(this)
        textView_optionThree_id.setOnClickListener(this)
        textView_optionFour_id.setOnClickListener(this)

        btn_submitAnswer_id.setOnClickListener(this)


    }

    private fun setQuestion() {

        val question = mQuestionList?.get(mCurrentPosition - 1)

        defaultOptionsView()

        if (mCurrentPosition == mQuestionList?.size) {
            btn_submitAnswer_id.text = "FINISH"
        } else {
            btn_submitAnswer_id.text = "SUBMIT"
        }

        progressBar_id.progress = mCurrentPosition

        textView_progressBar_id.text = "$mCurrentPosition/${progressBar_id.max}"

        textView_question_id.text = question?.question
        question?.image?.let {
            imageView_flag_id.setImageResource(it)
        }

        textView_optionOne_id.text = question?.optionOne
        textView_optionTwo_id.text = question?.optionTwo
        textView_optionThree_id.text = question?.optionThree
        textView_optionFour_id.text = question?.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, textView_optionOne_id)
        options.add(1, textView_optionTwo_id)
        options.add(2, textView_optionThree_id)
        options.add(3, textView_optionFour_id)

        for (option in options) {
            option.setTextColor(Color.parseColor("#FFAAAAAA"))
            option.typeface = Typeface.DEFAULT
            option.background =
                ContextCompat.getDrawable(this, R.drawable.text_border_outlined_option)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.textView_optionOne_id -> {
                selectedOptionView(textView_optionOne_id, 1)
            }

            R.id.textView_optionTwo_id -> {
                selectedOptionView(textView_optionTwo_id, 2)
            }

            R.id.textView_optionThree_id -> {
                selectedOptionView(textView_optionThree_id, 3)
            }

            R.id.textView_optionFour_id -> {
                selectedOptionView(textView_optionFour_id, 4)
            }

            R.id.btn_submitAnswer_id -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(
                                this,
                                "You have successfully completed the quiz!!!",
                                Toast.LENGTH_SHORT
                            ).show()

                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(USER_NAME,mUserName)
                            intent.putExtra(CORRECT_ANSWER,mCorrectAnswer)
                            intent.putExtra(TOTAL_QUESTIONS,mQuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)

                    if (question!!.answer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option)
                    }else{
                        mCorrectAnswer++
                    }

                    answerView(question.answer, R.drawable.correct_option)

                    if (mCurrentPosition == mQuestionList?.size) {
                        btn_submitAnswer_id.text = "FINISH"
                    } else {
                        btn_submitAnswer_id.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }
    }

    private fun selectedOptionView(textView: TextView, selectedOption: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOption

        textView.setTextColor(Color.parseColor("#000000"))
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.background =
            ContextCompat.getDrawable(this, R.drawable.selected_text_border_option)
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                textView_optionOne_id.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                textView_optionTwo_id.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                textView_optionThree_id.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                textView_optionFour_id.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }


}