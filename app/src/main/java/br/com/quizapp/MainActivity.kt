package br.com.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.quizapp.Constants.USER_NAME
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        btn_start_id.findViewById<Button>(R.id.btn_start_id)

        btn_start_id.setOnClickListener {
            val name:String = userName_id.text.toString()
            if (name.isNullOrEmpty()) {
                Snackbar.make(it, "Please, enter with your name!", Snackbar.LENGTH_LONG).setAction("Okay") {}.show()
            } else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(USER_NAME,name)
                startActivity(intent)
                finish()
            }
        }

    }
}