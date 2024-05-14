package net.ezra.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.Account.AccountScreen
import net.ezra.ui.Loginpage.LoginpageScreen
import net.ezra.ui.Myfarm.MyfarmScreen
import net.ezra.ui.SplashScreen
import net.ezra.ui.Statistics.StatisticsScreen
import net.ezra.ui.about.AboutScreen
import net.ezra.ui.auth.LoginScreen
import net.ezra.ui.auth.SignupScreen
import net.ezra.ui.contact.ContactScreen
import net.ezra.ui.home.HomeScreen
import net.ezra.ui.services.ServicesScreen
import net.ezra.ui.students.AddStudents
import net.ezra.ui.students.StudentList

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH


) {
    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_LOGINPAGE) {
            LoginpageScreen(navController)
        }


        composable(ROUTE_SIGNUP) {
            SignupScreen(navController)
        }


        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }


        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUTE_SERVICES) {
            ServicesScreen(navController)
        }



        composable(ROUTE_CONTACT) {
            ContactScreen(navController)
        }

        composable(ROUTE_ADD_STUDENTS) {
            AddStudents(navController)
        }

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUTE_STUDENTLIST) {
            StudentList(navController=navController, viewModel = viewModel())
        }

        composable(ROUTE_MYFARM) {
            MyfarmScreen(navController)
        }


        composable(ROUTE_STATISTICS) {
            StatisticsScreen(navController)
        }


        composable(ROUTE_ACCOUNT) {
            AccountScreen(navController)
        }





























    }
}