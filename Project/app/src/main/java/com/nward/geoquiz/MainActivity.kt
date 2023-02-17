package com.nward.geoquiz

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.nward.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quizViewModel:QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")

        binding.trueButton.setOnClickListener{ view: View ->
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener{ view: View ->
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener{
            quizViewModel.moveToNext()
            updateQuestion()
        }

        updateQuestion()

    }

    private fun updateQuestion(){
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean){
        var correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    override fun onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    override fun onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    override fun onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    override fun onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }


}