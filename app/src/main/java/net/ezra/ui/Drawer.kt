package net.ezra.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyDrawer(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerContent()
        },
        content = {
            // Your main content goes here
            MainContent(scaffoldState = scaffoldState, coroutineScope = coroutineScope)
        }
    )
}

@Composable
fun DrawerContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Item 1", color = Color.Black)
        Text(text = "Item 2", color = Color.Black)
        Text(text = "Item 3", color = Color.Black)
    }
}

@Composable
fun MainContent(scaffoldState: ScaffoldState, coroutineScope: CoroutineScope) {

    Column {

        Button(onClick = {
            coroutineScope.launch {
                scaffoldState.drawerState.open()
            }
        }) {
            Text("Open Drawer")
        }

//
//

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


                                @Composable
                                fun AccountIcon(
                                    size: Dp,
                                    strokeWidth: Dp,
                                    color: Color
                                ) {
                                    val radius = size / 2f
                                    val centerX = size.toPx() / 2
                                    val centerY = size.toPx() / 2

                                    Canvas(modifier = Modifier.size(size)) {
                                        // Draw circle for the account
//                                        drawCircle(
////                                            color = Color.Transparent,
//                                            radius = radius - strokeWidth.toPx(),
//                                            center = Offset(centerX, centerY),
//                                            style = Stroke(width = strokeWidth.toPx())
//                                        )
//
//                                        // Draw person shape inside the circle
//                                        drawLine(
//                                            color = color,
//                                            start = Offset(centerX - radius * 0.5f, centerY + radius * 0.3f),
//                                            end = Offset(centerX + radius * 0.5f, centerY + radius * 0.3f),
//                                            strokeWidth = strokeWidth.toPx()
//                                        )
//                                        drawCircle(
//                                            color = color,
//                                            radius = radius * 0.3f,
//                                            center = Offset(centerX, centerY - radius * 0.2f)
//                                        )
//                                        drawLine(
//                                            color = color,
//                                            start = Offset(centerX, centerY + radius * 0.3f),
//                                            end = Offset(centerX, centerY + radius * 0.7f),
//                                            strokeWidth = strokeWidth.toPx()
//                                        )
                                    }
                                }

                    }
                }





    }
    // Your main content goes here

    // Example of a button to open the drawer



}

