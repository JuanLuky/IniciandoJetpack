package com.juanluky.iniciandojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juanluky.iniciandojetpack.ui.theme.IniciandoJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IniciandoJetpackTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("Android", "Compose", "Kotlin")
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.Black)
            .padding(top = 20.dp, bottom = 10.dp)
        ) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {

    var expanded = remember {
        mutableStateOf(false)
    }

    Surface(
        color = MaterialTheme.colorScheme.secondary,
        shape = RoundedCornerShape(10),
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 10.dp)

    ) {
        // Don't copy over
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text("Blog")
                Text(text = name)
            }

            ElevatedButton(
                onClick = {  expanded.value = !expanded.value }
            ) {
                Text(
                    text = if (expanded.value) "Show less" else "Show more",

                )
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    IniciandoJetpackTheme {
        MyApp()
    }
}