package net.ezra.ui.Statistics


import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun StatisticsScreen(navController: NavHostController) {


    {

    }
    Column {



                @Composable
                fun StatisticsGraph() {
                    val fertilizerConsumed = listOf(10f, 20f, 15f, 25f, 30f) // Sample data for fertiliser consumed
                    val bagsHarvested = listOf(50f, 55f, 60f, 58f, 65f) // Sample data for bags harvested
                    val weather = listOf("Rainy", "Sunny", "Cloudy", "Rainy", "Sunny") // Constant weather data

                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    ) {
                        val canvasWidth = size.width
                        val canvasHeight = size.height

                        val maxYValue = maxOf(fertilizerConsumed.maxOrNull() ?: 0f, bagsHarvested.maxOrNull() ?: 0f)
                        val minYValue = 0f

                        val xInterval = canvasWidth / (fertilizerConsumed.size - 1)
                        val yInterval = canvasHeight / (maxYValue - minYValue)

                        // Draw X and Y axis
                        drawLine(start = Offset(0f, 0f), end = Offset(0f, canvasHeight), color = Color.Black, strokeWidth = 2f)
                        drawLine(start = Offset(0f, canvasHeight), end = Offset(canvasWidth, canvasHeight), color = Color.Black, strokeWidth = 2f)

                        // Draw line for Fertiliser Consumed
                        val path1 = Path()
                        fertilizerConsumed.forEachIndexed { index, value ->
                            val x = index * xInterval
                            val y = canvasHeight - (value - minYValue) * yInterval
                            if (index == 0) {
                                path1.moveTo(x, y)
                            } else {
                                path1.lineTo(x, y)
                            }
                        }
                        drawPath(path = path1, color = Color.Blue, style = Stroke(width = 4f))

                        // Draw line for Bags Harvested
                        val path2 = Path()
                        bagsHarvested.forEachIndexed { index, value ->
                            val x = index * xInterval
                            val y = canvasHeight - (value - minYValue) * yInterval
                            if (index == 0) {
                                path2.moveTo(x, y)
                            } else {
                                path2.lineTo(x, y)
                            }
                        }
                        drawPath(path = path2, color = Color.Red, style = Stroke(width = 4f))
                    }
                }





    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    StatisticsScreen(rememberNavController())
}

