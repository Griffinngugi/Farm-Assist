package net.ezra.ui.home

//import androidx.test.espresso.base.Default

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.format.TextStyle
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")


@Composable
fun HomeScreen(navController: NavHostController) {
}

@Composable

fun DrawerContent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {


        Text(text = "Home", color = Color.Black)
        Text(text = "Myfarm", color = Color.Black)
        Text(text = "Statistics", color = Color.Black)
        Text(text = "Account", color = Color.Black)




    }
}

@Composable
fun MainContent(scaffoldState: ScaffoldState, coroutineScope: CoroutineScope) {

    fun drawCircle(color: Color, radius: Dp, center: Offset, style: Stroke) {
        TODO("Not yet implemented")
    }
    Column {

        Button(onClick = {
            coroutineScope.launch {
                scaffoldState.drawerState.open()
            }
        }) {
            Text("Menu")
        }



                @Composable
                fun AccountIcon(
                    size: Dp,
                    strokeWidth: Dp,
                    color: Color
                ) {
                    Canvas(modifier = Modifier.size(size)) {
                        val radius = size / 2f
                        val centerX = size.toPx() / 2
                        val centerY = size.toPx() / 2

                        // Draw the circle for the account
                        drawCircle(
                            color = Color.Transparent,
                            radius = radius - strokeWidth.toPx(),
                            center = Offset(centerX, centerY),
                            style = Stroke(width = strokeWidth.toPx())
                        )

                        // Draw person shape inside the circle
                        drawLine(
                            color = color,
                            start = Offset(centerX + radius * 0.5f, centerY + radius * 0.3f),
                            end = Offset(centerX + radius * 0.5f, centerY + radius * 0.3f),
                            strokeWidth = strokeWidth.toPx()
                        )
                        drawCircle(
                            color = color,
                            radius = radius * 0.3f,
                            center = Offset(centerX, centerY + radius * 0.2f),
                            style = Stroke(width = strokeWidth.toPx())
                        )
                        drawLine(
                            color = color,
                            start = Offset(centerX, centerY + radius * 0.3f),
                            end = Offset(centerX, centerY + radius * 0.7f),
                            strokeWidth = strokeWidth.toPx()
                        )
                    }
                }

        @Composable
        fun SearchBar(
            modifier: Modifier = Modifier,
            onSearchSubmitted: (String) -> Unit
        ) {
            var searchText by remember { mutableStateOf(TextFieldValue()) }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Gray
                )

                Spacer(modifier = Modifier.width(8.dp))

                BasicTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    singleLine = true,
//                    textStyle = TextStyle.Default.copy(color = Color.Black),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .padding(vertical = 8.dp)
                )

                if (searchText.text.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear",
                        tint = Color.Gray,
                        modifier = Modifier.clickable {
                            searchText = TextFieldValue("")
                        }
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Gray,
                    modifier = Modifier.clickable {
                        onSearchSubmitted(searchText.text)
                    }
                )
            }
        }

        @Composable
        fun PreviewSearchBar() {
            SearchBar(onSearchSubmitted = { })
        }

        @Composable
        fun WeatherCard(
            location: String,
            currentConditions: String,
            temperature: String,
            feelsLike: String,
            wind: String,
            humidity: String,
            visibility: String,
            sunrise: String,
            sunset: String,
            lastUpdated: String
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = location,
                    style = MaterialTheme.typography.h6,
                    fontSize = 20.sp,
                    color = MaterialTheme.colors.primary,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = currentConditions,
                    style = MaterialTheme.typography.body1,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onSurface,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Temperature: $temperature",
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = "Feels Like: $feelsLike",
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = "Wind: $wind",
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = "Humidity: $humidity",
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = "Visibility: $visibility",
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = "Sunrise: $sunrise",
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = "Sunset: $sunset",
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Text(
                    text = "Last Updated: $lastUpdated",
                    style = MaterialTheme.typography.caption,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.onSurface
                )
            }
        }


        @Composable
        fun PreviewWeatherCard() {
            WeatherCard(
                location = "New York, NY",
                currentConditions = "Partly Cloudy",
                temperature = "63°F (17°C)",
                feelsLike = "65°F (18°C)",
                wind = "N 10 mph",
                humidity = "55%",
                visibility = "10 miles",
                sunrise = "6:30 AM",
                sunset = "7:45 PM",
                lastUpdated = "April 24, 2024, 3:00 PM"
            )
        }




                @Composable
                fun DrawerItemCard(
                    text: String,
                    navController: NavController
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                // Navigate to the corresponding screen when the card is clicked
                                when (text) {
                                    "Home" -> navController.navigate("Home_route")
                                    "Myfarm" -> navController.navigate("Myfarm_route")
                                    "Statistics" -> navController.navigate("Statistics_route")
                                    "Account" -> navController.navigate("Account_route")
                                    // Add more cases for other items as needed
                                }
                            },
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = Color.White,
                        elevation = 4.dp
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = text,
                                color = Color.Black,
                                fontSize = 16.sp,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }

        @Composable
        fun DrawerContent(
            navController: NavController
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                DrawerItemCard(text = "Home", navController = navController)
                DrawerItemCard(text = "Myfarm", navController = navController)
                DrawerItemCard(text = "Statistics", navController = navController)
                DrawerItemCard(text = "Account", navController = navController)
                // Add more DrawerItemCard composable calls for other items as needed
            }
        }

        @Composable
        fun AppDrawer(
            navController: NavController
        ) {
            // Drawer implementation
            // ...

            // Inside your Drawer:
            DrawerContent(navController = navController)
        }

        @Composable
        fun MainScreen(
            navController: NavController
        ) {
            // Main screen UI
            // ...

            // Drawer implementation
            AppDrawer(navController = navController)
        }

    }


                }

private fun <DrawScope> DrawScope.drawCircle(color: Color, radius: Unit, center: Offset, style: Stroke) {

}

private operator fun Dp.minus(toPx: Float) {

}


private operator fun Float.plus(dp: Dp): Float {

    return TODO("Provide the return value")
}

//private operator fun Float.minus(dp: Dp): Float {


//    @Composable
//    fun HomeScreenPreviewLight() {
//        net.ezra.ui.home.HomeScreen(rememberNavController())
//    }
//




