package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.findViewTreeLifecycleOwner
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonButtonAndText()
}

@Composable
fun LemonButtonAndText(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    var counter by remember { mutableStateOf(1) }

    val imageResourceButton  = when (counter) {
        1 -> R.drawable.lemon_tree
        6 -> R.drawable.lemon_drink
        7 -> R.drawable.lemon_drink
        8 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_squeeze
    }

    val stringResource = when (counter){
        1 -> R.string.make_taptree
        6 -> R.string.make_drink
        7 -> R.string.make_drink
        8 -> R.string.make_start
        else -> R.string.make_squeeze
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            if (counter == 8){
                counter = 1
            }else if(counter > 1 && counter < 6){
                counter += Random.nextInt(1, 3)
            }
            else if(counter == 6){
                counter = 8
            }else{
                counter ++
            }

        }) {
            Image(
                painter = painterResource(imageResourceButton),
                contentDescription = null)
        }
        Spacer(
            Modifier
                .height(16.dp)
        )
        Text(stringResource(stringResource))
    }
}

