package com.example.truefalse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // opening the raw resource and reading the file as a string
        val inputStream = resources.openRawResource(R.raw.questions)
        val inputString = inputStream.bufferedReader().use {
            it.readText()
        }
        Log.d(TAG, "onCreate: " + inputString)

        // parsing the string into our custom objects using Gson
        val gson = Gson()
        // use the parsing between the collection, list, or array section of:
        // https://medium.com/@hissain.khan/parsing-with-google-gson-library-in-android-kotlin-7920e26f5520
        // question = Gson().fromJson(inputString, Question::class.java)
        val sType  = object : TypeToken<List<Question>>() {}.type
        val questions = gson.fromJson<List<Question>>(inputString, sType)

        Log.d(TAG, "AFTER: " + questions.toString())

        // construct a quiz object
        val quiz = Quiz(questions)

        var questionIndex = 0

    fun setButtonText(question : Question) {
        textView_main_question.text = question.answers.keys.elementAt(questionIndex)
        radioButton_main_answer1.text = question.answers[0].toString()
        radioButton_main_answer2.text = question.answers[1].toString()
        radioButton_main_answer3.text = question.answers[2].toString()
        radioButton_main_answer4.text = question.answers[3].toString()

        questionIndex++
    }

        radioButton_main_answer1.setOnClickListener {
            quiz.checkAnswer(radioButton_main_answer1.text.toString())
            if(quiz.hasNextQuestion()) {
                setButtonText(quiz.getNextQuestion())
            }
            else {
                quiz.finalCheck()
            }
        }

        radioButton_main_answer2.setOnClickListener {
            quiz.checkAnswer(radioButton_main_answer2.text.toString())
            if(quiz.hasNextQuestion()) {
                setButtonText(quiz.getNextQuestion())
            }
            else {
                quiz.finalCheck()
            }
        }

        radioButton_main_answer3.setOnClickListener {
            quiz.checkAnswer(radioButton_main_answer3.text.toString())
            if(quiz.hasNextQuestion()) {
                setButtonText(quiz.getNextQuestion())
            }
            else {
                quiz.finalCheck()
            }
        }

        radioButton_main_answer4.setOnClickListener {
            quiz.checkAnswer(radioButton_main_answer4.text.toString())
            if(quiz.hasNextQuestion()) {
                setButtonText(quiz.getNextQuestion())
            }
            else {
                quiz.finalCheck()
            }
        }



        // get the first question and set the text fields & buttons to match
        // to test, call a few of the functions in the Quiz class and see if they do what you expect them to do.

        // in the button listeners, when the user clicks on something,
        // it passes the info on to the Quiz class. The Quiz class decides if
        // it's right or wrong and updates its score.
        // We check if there are more questions

    }

}