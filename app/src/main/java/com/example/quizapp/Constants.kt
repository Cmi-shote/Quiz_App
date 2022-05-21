package com.example.quizapp

object Constants {

    const val UserName : String = "user_name"
    const val TotalQuestions : String = "total_questions"
    const val CorrectAnswers : String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Austria",
            "United States", "Canada",
            1)

        questionsList.add(que1)

        val que2 = Question(
            2,"What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium", "Colombia",
            "Germany", "Brazil",
            1)

        questionsList.add(que2)

        val que3 = Question(
            3,"What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Chile",
            "Australia", "Italy",
            3)

        questionsList.add(que1)

        val que4 = Question(
            4,"What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil", "India",
            "Greece", "China",
            1)

        questionsList.add(que4)

        val que5 = Question(
            5,"What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Cameroon", "Finland",
            "Denmark", "Indonesia",
            3)

        questionsList.add(que5)

        val que6 = Question(
            6,"What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Bangladesh", "Fiji",
            "Kuwait", "South korea",
            2)

        questionsList.add(que6)

        val que7 = Question(
            7,"What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "France", "Nigeria",
            "Mali", "Kuwait",
            4)

        questionsList.add(que7)

        val que8 = Question(
            8,"What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "United States", "Denmark",
            "Greece", "Germany",
            4)

        questionsList.add(que8)

        val que9 = Question(
            9,"What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Switzerland", "Finland",
            "India", "Ukraine",
            3)

        questionsList.add(que9)

        val que10 = Question(
            10,"What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Angola", "Sweden",
            "Mexico", "New Zealand",
            4)

        questionsList.add(que10)

        return questionsList
    }
}