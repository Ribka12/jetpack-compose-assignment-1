package com.example.courseapp.ui

import android.R.attr.text
import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.courseapp.model.Course
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.courseapp.ui.theme.Background
import com.example.courseapp.ui.theme.CourseAppTheme
import com.example.courseapp.ui.theme.PrimaryContainer
import com.example.courseapp.ui.theme.TertiaryContainer


@Composable
fun CourseCard(course: Course) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }


    Card(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 16.dp)
            .fillMaxWidth()
            .background(Color(0xFFFAFAFA))
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),

        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = course.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier=Modifier.height(8.dp))

                    Text(
                        text = course.code,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        ),

                    )

                    Spacer(modifier=Modifier.height(
                        if(isExpanded) 10.dp else 24.dp
                    ))

                    Text(
                        text = "${course.creditHours} Credit Hours",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }

                IconButton(onClick = { isExpanded = !isExpanded }) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (isExpanded) "Collapse" else "Expand",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            if (isExpanded) {
                Spacer(modifier = Modifier.height(48.dp))

                Row {
                    Text(
                        "Description:  " ,
                        style= MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = course.description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 3.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    Text(
                        "Prerequisites:  ",
                        style= MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,

                    )
                    Text(
                        text = course.prerequisites,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 3.dp)

                    )
                }

            }
        }
    }
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Course Card - Light Theme"
)
@Composable
fun CourseCardLightPreview() {
    CourseAppTheme(useDarkTheme = false) {
        CourseCard(
            course = Course(
                "DSA",
                "CS499",
                3,
                "Covers Lists, Stacks, Queues, and more",
                "None"
            )
        )
    }
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Course Card - Dark Theme"
)
@Composable
fun CourseCardDarkPreview() {
    CourseAppTheme(useDarkTheme = true) {
        CourseCard(
            course = Course(
                "DSA",
                "CS499",
                3,
                "Covers Lists, Stacks, Queues, and more",
                "None"
            )
        )
    }
}

