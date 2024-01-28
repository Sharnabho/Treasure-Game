package com.example.treasuregame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.treasuregame.ui.theme.TreasureGameTheme
import java.net.NoRouteToHostException
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasureGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TreasureGame()
                }
            }
        }
    }
}

@Composable
fun TreasureGame()
{
    val treasureFound = remember {mutableStateOf(0)}
    val direction = remember {mutableStateOf("North")}
    val stormOrTreasure = remember {mutableStateOf("")}
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Number of Treasures found : ${treasureFound.value}")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Current direction of ship : ${direction.value}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            direction.value = "North"
            if(Random.nextBoolean()){
                treasureFound.value += 1
                stormOrTreasure.value = "Treasure Found!"
            }
            else{
                stormOrTreasure.value = "Storm Ahead!"
            }
        }) {
            Text("North")
        }
        Row {
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { direction.value = "West"
                if(Random.nextBoolean()){
                    treasureFound.value += 1
                    stormOrTreasure.value = "Treasure Found!"
                }
                else{
                    stormOrTreasure.value = "Storm Ahead!"
                }

            }) {

                Text("West")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                direction.value = "East"
                if(Random.nextBoolean()){
                    treasureFound.value += 1
                    stormOrTreasure.value = "Treasure Found!"
                }
                else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text("East")
            }
        }
        //Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            direction.value = "South"
            if(Random.nextBoolean()){
                treasureFound.value += 1
                stormOrTreasure.value = "Treasure Found!"
            }
            else{
                stormOrTreasure.value = "Storm Ahead!"
            }
        }) {
            Text("South")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("${stormOrTreasure.value}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            treasureFound.value = 0
            direction.value = "North"
            stormOrTreasure.value = ""
        }) {
            Text("Reset")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TreasureGamePreview() {
    TreasureGameTheme {
        TreasureGame()
    }
}