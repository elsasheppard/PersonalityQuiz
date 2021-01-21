package com.example.truefalse

import kotlin.math.max

// include in the constructor a parameter fot the list of questions

// include variables for the score

class Quiz(var questions: List<Question>) {
    var currentQuestionIndex = 0

    /**
     * @return: whether or not another question exists in the list of questions
     */
    fun hasNextQuestion() : Boolean {
        return currentQuestionIndex < questions.size
    }

    /**
     * Precondition: another question exists in the list of questions to return
     */
    fun getNextQuestion() : Question {
        currentQuestionIndex++
        return questions[currentQuestionIndex - 1]
    }

    val answers = HashMap<String, Int>()
    var l = 0
    var light = 0
    var ryuk = 0
    var madsuda = 0


    fun checkAnswer(key : String) {
        // add up numbers based on which question they picked
        val personId = answers[key]

        when(personId) {
            1 -> l++
            2 -> light++
            3 -> ryuk++
            4 -> madsuda
        }
    }

    fun finalCheck() : String {
        var result = max(l, max(light, max(ryuk, madsuda)))
        when (result) {
            l -> {
                return "You are L"
            }
            light -> {
                return "You are Light Yagami"
            }
            ryuk -> {
                return "You are Ryuk"
            }
            else -> {
                return "You are Madsuda"
            }
        }
    }
}