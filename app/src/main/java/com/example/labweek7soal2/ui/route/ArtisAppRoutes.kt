package com.example.labweek7.ui.routes

import ArtisViewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.labweek7soal2.ui.view.ArtisAppView

object ArtisAppRoutes {
    const val AWAL = "artist_detail"
    const val ALBUM_DETAIL = "album_detail"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    currentView: ArtisAppView?,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = currentView?.title ?: "",
                color = Color.White,
                fontSize = 20.sp
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Cart",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFFD81B60) // warna magenta
        ),
        modifier = modifier
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Soal1AppRouting() {
    val navController = rememberNavController()
    val s1VM: ArtisViewModel = viewModel()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route
    val currentView = ArtisAppVie.entries.find { it.name == currentRoute }

    Scaffold(
        topBar = {
            MyTopAppBar(
                currentView = currentView ?: Soal1AppView.Soal1,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Soal1AppView.Soal1.name
        ) {
            composable(route = Soal1AppView.Soal1.name) {
                Soal1(s1VM = s1VM, navController = navController)
            }
            composable(route = Soal1AppView.Soal1Pandamart.name) {
                Soal1Pandamart(s1VM = s1VM)
            }
            composable(route = Soal1AppView.Soal1FoodDelivery.name) {
                Soal1FoodDelivery(s1VM = s1VM)
            }
        }
    }
}
