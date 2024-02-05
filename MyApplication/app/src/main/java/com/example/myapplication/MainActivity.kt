package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.SmartBuyTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        setContentView(R.layout.activity_main)
        setContent{
            SmartBuyTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val countVM : CountMainViewModel = viewModel()
                    val count by countVM.count.observeAsState(0)
                            //                    SimpleComposable()
                    //                   ItemScreen()
                   // val (count, onCountChange) = remember{mutableStateOf(0)}
                    ConstraintItemScreen(count){newCount -> countVM.onCountChanged(newCount) }
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

@Composable
fun ItemScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight()) {

        BoxDay3Screen(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .height(300.dp)
             .weight(3f),

        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = "0", onValueChange = { /*TODO*/ }, modifier = Modifier.padding(4.dp))

        //Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = {}, modifier = Modifier.padding(4.dp).weight(1f)) {
                Text("Increase")
            }

            Button(onClick = {}, modifier = Modifier.padding(4.dp).weight(1f)) {
                Text("Decrease")
            }
        }
    }
}



@Composable
fun BoxDay3Screen( modifier: Modifier){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Box(modifier = Modifier.size(200.dp).background(Color.Blue))
        Box(modifier = Modifier.size(100.dp).background(Color.Red))

        Box(modifier = Modifier.size(100.dp).background(Color.Green).align(Alignment.TopStart))
        Box(modifier = Modifier.size(100.dp).background(Color.Green).align(Alignment.TopEnd))
        Box(modifier = Modifier.size(100.dp).background(Color.Green).align(Alignment.BottomStart))
        Box(modifier = Modifier.size(100.dp).background(Color.Green).align(Alignment.BottomEnd))

    }

}

@Composable
fun ConstraintItemScreen(count: Int, onCountChange: (Int) -> Unit){
    val boxSize = 400.dp
    val constraints = ConstraintSet{
        val box = createRefFor("box")
        val textbox = createRefFor("textbox")
        val input = createRefFor("input")
        val increase = createRefFor("increase")
        val decrease = createRefFor("decrease")

        constrain(box){
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
        }
        constrain(input){
            top.linkTo(box.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(textbox){
          start.linkTo(parent.start)
            top.linkTo(input.bottom)
         //  top.linkTo(parent.top)
            end.linkTo(parent.end)
        }



        constrain(increase) {
            start.linkTo(parent.start)
            top.linkTo(textbox.bottom)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            end.linkTo(decrease.start)
        }

        constrain(decrease){
            top.linkTo(increase.top)
            end.linkTo(parent.end)
            bottom.linkTo(increase.bottom)
            width = Dimension.fillToConstraints
            start.linkTo(increase.end)
        }

    }
    ConstraintLayout(modifier = Modifier.fillMaxHeight(), constraintSet = constraints){
       // val (box, input, increase, decrease) = createRefs()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .height(500.dp)
                .layoutId("box")
            , contentAlignment = Alignment.Center
        ) {
            var childSize = boxSize - 20.dp
            for(i in 0 until count) {
                Box(
                    modifier = Modifier.size(childSize).rotate(i * 3f)
                        .background(Color.Gray).border(1.dp, Color.Black)
                )
                childSize -= 20.dp
            }
        }


        TextField(value = "${count}", onValueChange = { /*TODO*/ },
            modifier = Modifier.padding(4.dp)
                .layoutId("input")
        )
        TextUi("Welcome To Jetpack Compose")




        Button(onClick = {
            onCountChange(1)
        }, modifier = Modifier
            .padding(4.dp)
            .layoutId("increase")
        ) {
            Text("Increase")
        }

        Button(onClick = {

            onCountChange(-1)
        }, modifier = Modifier
            .padding(4.dp)
            .layoutId("decrease")
        ) {
            Text("Decrease")
        }


    }
}


@Composable
 fun TextUi(text: String) {
    Box(
        modifier = Modifier
        .fillMaxWidth()
            .background(Color.Blue)
            .height(150.dp)
            .layoutId("textbox")
        , contentAlignment = Alignment.Center
    ) {
        //val customFont = Font(R.font.chango)
        val customFontFamily = FontFamily.Serif
        BasicText(text = "Welcome", style = TextStyle.Default.copy(color = Color.DarkGray, fontSize = 17.sp, fontFamily = customFontFamily))
        Spacer(Modifier.height(16.dp))
        BasicText(text = text, modifier = Modifier.padding(4.dp), style = TextStyle.Default.copy(color = Color.Red, fontSize = 17.sp, fontFamily = customFontFamily))
        Text(text = text, modifier = Modifier.padding(4.dp), style = MaterialTheme.typography.displaySmall.copy(color = Color.Green, fontSize = 15.sp, fontStyle = FontStyle.Italic))
    }
}




@Preview
@Composable
fun PreviewSimpleComposable() {
    SimpleComposable()
}
