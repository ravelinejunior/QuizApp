package br.com.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.quizapp.Constants.CORRECT_ANSWER
import br.com.quizapp.Constants.TOTAL_QUESTIONS
import br.com.quizapp.Constants.USER_NAME
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(USER_NAME)
        val correctAnswer = intent.getIntExtra(CORRECT_ANSWER, 0)
        val totalAnswer = intent.getIntExtra(TOTAL_QUESTIONS, 0)

        userName_textView_id.text = userName
        score_textView_id.text = "Your Score Is $correctAnswer Out Of $totalAnswer"

        btn_finish_id.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_finish_id -> {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}