package br.com.quizapp

data class Question(
    val id: Int,
    val answer: Int,
    val image: Int,
    val question:String,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
)
