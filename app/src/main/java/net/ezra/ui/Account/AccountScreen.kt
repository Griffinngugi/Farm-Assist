package net.ezra.ui.Account


import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountScreen(navController: NavHostController) {




    Column {


                @Composable
                fun AccountPage(onLogout: () -> Unit) {
                    var myCropsFeedback by remember { mutableStateOf("") }
                    var shareFeedback by remember { mutableStateOf("") }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // My Crops Input Card
                        InputCard(
                            title = "My Crops",
                            onValueChanged = {
                                val it = ""
                                myCropsFeedback = it
                            },
                            value = myCropsFeedback
                        )

                        // Share Feedback Input Card
                        InputCard(
                            title = "Share Your Feedback",
                            onValueChanged = {
                                val it = ""
                                shareFeedback = it
                            },
                            value = shareFeedback
                        )

                        // Logout Button
                        Button(onClick = onLogout) {
                            Text(text = "Logout")
                        }
                    }
                }

        @Composable
        fun InputCard(title: String, onValueChanged: (String) -> Unit, value: String) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = title, style = MaterialTheme.typography.h6)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = value,
                        onValueChange = { onValueChanged(it) },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Enter your $title here") }
                    )
                }
            }
        }
        @Composable
        fun YourApp() {
            var isLoggedIn by remember { mutableStateOf(true) }

            if (isLoggedIn) {
                AccountPage(onLogout = { isLoggedIn = false })
            } else {
                // Show login screen or navigate to login screen
            }
        }

    }

}

class InputCard(title: String, onValueChanged: () -> Unit, value: String) {

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AccountScreenPreviewLight() {
    AccountScreen(rememberNavController())
}

