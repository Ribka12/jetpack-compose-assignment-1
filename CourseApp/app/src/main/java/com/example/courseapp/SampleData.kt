package com.example.courseapp

import com.example.courseapp.model.Course

object SampleData {
    val courseList = listOf(
        Course(
            title = "Web Development",
            code = "CS410",
            creditHours = 5,
            description = "Covers front-end and back-end web development, including HTML, CSS, JavaScript, REST APIs, and web frameworks like React and Node.js.",
            prerequisites = "CS201"
        ),

        Course(
            title = "Mobile Application Development",
            code = "CS420",
            creditHours = 3,
            description = "Focuses on developing native Android apps using Kotlin and Jetpack Compose, along with mobile UI design, data storage, and network communication.",
            prerequisites = "CS201"
        ),

        Course(
            title = "Operating Systems",
            code = "CS301",
            creditHours = 4,
            description = "Explore how OS manages hardware and software resources.",
            prerequisites = "CS201"
        ),

        Course(
            title = "Database Systems",
            code = "CS330",
            creditHours = 3,
            description = "Introduces relational database concepts, SQL, normalization, ER modeling, and database management system architecture.",
            prerequisites = "CS201"
        ),




    )
}
