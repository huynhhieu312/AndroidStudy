package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.SmartBuyTheme
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContent{
            SmartBuyTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SimpleComposable()
                }
            }

        }

    }
}


@Composable
fun SimpleComposable( modifier: Modifier = Modifier) {

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            Text(
                text = "Text Text",
                fontSize = 15.sp,
               // lineHeight = 116.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "From",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .padding(16.dp)
//                    .align(alignment = Alignment.End)
            )
        }



}

@Preview
@Composable
fun PreviewSimpleComposable() {
    SimpleComposable()
}
