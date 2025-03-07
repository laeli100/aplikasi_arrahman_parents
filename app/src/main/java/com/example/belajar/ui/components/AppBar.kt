package com.example.belajar.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.belajar.R

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("chat") { ChatScreen() }
        composable("profile") { ProfileScreen() }
    }
}

@Composable
fun CustomBottomAppBar(navController: NavController) {
    val activeBar = remember { mutableStateOf("home") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
            .background(Color(0xFF00283A))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconWithAnimation(
                isActive = activeBar.value == "chat",
                onClick = {
                    activeBar.value = "chat"
                    navController.navigate("chat")
                },
                iconRes = R.drawable.icchat,
                description = "Chat Icon"
            )

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(if (activeBar.value == "home") Color.Gray else Color.White),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = {
                    activeBar.value = "home"
                    navController.navigate("home")
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ichome),
                        contentDescription = "Home Icon",
                        modifier = Modifier.size(48.dp),
                        tint = Color.Unspecified
                    )
                }
            }

            IconWithAnimation(
                isActive = activeBar.value == "profile",
                onClick = {
                    activeBar.value = "profile"
                    navController.navigate("profile")
                },
                iconRes = R.drawable.icprofil,
                description = "Profile Icon"
            )
        }
    }
}

@Composable
fun IconWithAnimation(
    isActive: Boolean,
    onClick: () -> Unit,
    iconRes: Int,
    description: String
) {
    val backgroundColor = if (isActive) Color.Gray else Color.Transparent
    val verticalOffset by animateDpAsState(
        targetValue = if (isActive) (-10).dp else 0.dp,
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier = Modifier
            .padding(top = verticalOffset)
            .clip(CircleShape)
            .background(backgroundColor)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = description,
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun HomeScreen() {
    Box(Modifier.fillMaxSize().background(Color.Green), contentAlignment = Alignment.Center) {
        androidx.compose.material3.Text("Home Screen")
    }
}

@Composable
fun ChatScreen() {
    Box(Modifier.fillMaxSize().background(Color.Blue), contentAlignment = Alignment.Center) {
        androidx.compose.material3.Text("Chat Screen")
    }
}

@Composable
fun ProfileScreen() {
    Box(Modifier.fillMaxSize().background(Color.Red), contentAlignment = Alignment.Center) {
        androidx.compose.material3.Text("Profile Screen")
    }
}

@Preview
@Composable
fun CustomBottomAppBarPreview() {
    val navController = rememberNavController()
    Column {
        Box(modifier = Modifier.weight(1f)) {
            NavigationGraph(navController)
        }
        CustomBottomAppBar(navController)
    }
}
