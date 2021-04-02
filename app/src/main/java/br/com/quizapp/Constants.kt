package br.com.quizapp

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWER:String="correct_answer"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1,
            1,
            R.drawable.ic_flag_of_argentina,
            "What country does this flag belong to?",
            "Argentina",
            "Australia",
            "Armenia",
            "Austria"
        )
        questionsList.add(question1)

        val question2 = Question(
            1,
            4,
            R.drawable.ic_flag_of_australia,
            "What country does this flag belong to?",
            "Argentina",
            "Brazil",
            "German",
            "Australia"
        )
        questionsList.add(question2)

        val que3 = Question(
            3,
            4,
            R.drawable.ic_flag_of_brazil,
            "What country does this flag belong to?",
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4,
            2,
            R.drawable.ic_flag_of_belgium,
            "What country does this flag belong to?",
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5,
            3,
            R.drawable.ic_flag_of_fiji,
            "What country does this flag belong to?",
            "Gabon",
            "France",
            "Fiji",
            "Finland",
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6,
            1,
            R.drawable.ic_flag_of_germany,
            "What country does this flag belong to?",
            "Germany",
            "Georgia",
            "Greece",
            "none of these",
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7,
            3,
            R.drawable.ic_flag_of_denmark,
            "What country does this flag belong to?",
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",

            )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8,
            4,
            R.drawable.ic_flag_of_india,
            "What country does this flag belong to?",
            "Ireland",
            "Iran",
            "Hungary",
            "India",
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9,
            2,
            R.drawable.ic_flag_of_new_zealand,
            "What country does this flag belong to?",
            "Australia",
            "New Zealand",
            "Tuvalu",
            "United States of America",
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10,
            1,
            R.drawable.ic_flag_of_kuwait,
            "What country does this flag belong to?",
            "Kuwait",
            "Jordan",
            "Sudan",
            "Palestine",
        )

        questionsList.add(que10)
        return questionsList
    }
}