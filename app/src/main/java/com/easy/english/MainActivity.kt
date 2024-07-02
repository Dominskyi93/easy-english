package com.easy.english

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.easy.english.ui.theme.EasyLearnEnglishTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyLearnEnglishTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {

                    },
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        DestinationsNavHost(
                            navGraph = NavGraphs.root,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}