package com.enesturkoglu.pawtrackv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.enesturkoglu.pawtrackv2.navigation.MyApp
import com.enesturkoglu.pawtrackv2.screens.petlist.PetListScreen
import com.enesturkoglu.pawtrackv2.screens.petlist.PetListScreenViewModel

import com.enesturkoglu.pawtrackv2.ui.theme.PawTrackV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            MyApp()
            }
        }
    }




