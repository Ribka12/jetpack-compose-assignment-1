package com.example.courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.courseapp.ui.CourseListScreen
import com.example.courseapp.ui.theme.CourseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseAppTheme {
                CourseListScreen(courses = SampleData.courseList)
            }
        }
    }
}
