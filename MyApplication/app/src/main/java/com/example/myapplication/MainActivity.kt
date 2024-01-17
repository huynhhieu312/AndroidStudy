package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.SmartBuyTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material.*
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContent{
            SmartBuyTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
//                    SimpleComposable()
 //                   ItemScreen()
                    ConstraintItemScreen()
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
fun ConstraintItemScreen() {
    val constraints = ConstraintSet{
        val box = createRefFor("box")
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

        constrain(increase) {
            start.linkTo(parent.start)
            top.linkTo(input.bottom)
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
            Box(modifier = Modifier
                .size(200.dp)
                .background(Color.Blue))
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Red))

            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .align(Alignment.TopStart))
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .align(Alignment.TopEnd))
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .align(Alignment.BottomStart))
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .align(Alignment.BottomEnd))


        }


        TextField(value = "0", onValueChange = { /*TODO*/ },
            modifier = Modifier.padding(4.dp)
                .layoutId("input")
        )


        Button(onClick = {}, modifier = Modifier
            .padding(4.dp)
            .layoutId("increase")
        ) {
            Text("Increase")
        }

        Button(onClick = {}, modifier = Modifier
            .padding(4.dp)
            .layoutId("decrease")
        ) {
            Text("Decrease")
        }


    }
}



@Preview
@Composable
fun PreviewSimpleComposable() {
    SimpleComposable()
}
