package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage
import com.example.myapplication.ui.theme.AnimatedVisibilityMotionTheme

import androidx.compose.animation.*

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import com.example.myapplication.ui.theme.SwapContentMotionTheme


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        setContentView(R.layout.activity_main)
        setContent{
//            SmartBuyTheme(darkTheme = false) {
//                Surface(
//                    modifier = Modifier.fillMaxSize()
//                ) {
//                    val countVM : CountMainViewModel = viewModel()
//                    val count by countVM.count.observeAsState(0)
//                            //                    SimpleComposable()
//                    //                   ItemScreen()
//                   // val (count, onCountChange) = remember{mutableStateOf(0)}
//                    ConstraintItemScreen(count){newCount -> countVM.onCountChanged(newCount) }
//                }
//            }
 //           ComposeImages()
//            AnimatedVisibilityMotionTheme {
//                AnimatedVisibilitySample()
//            }

            SwapContentMotionTheme {
               // AnimatedVisibilitySample()
                AnimationDemo()
            }
           // NetworkImage()
        }

    }
}

@Composable
fun NetworkImage() {
    Column{

     // CoilImage(data = "https://picsum.photos/400/400", contentDescription = "Network Image", fadeIn = true)
        SubcomposeAsyncImage(
            model = "https://picsum.photos/400/400",
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = "Network Image"
        )
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
                .height(350.dp)
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


//        TextField(value = "${count}", onValueChange = { /*TODO*/ },
//            modifier = Modifier.padding(4.dp)
//                .layoutId("input")
//        )
        MyTextInput()
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
fun MyTextInput() {
    Column{
        Text("BasicTextField")
        var basicText by remember{mutableStateOf("")}
        BasicTextField(value = basicText, onValueChange = {basicText = it}, Modifier.padding(8.dp))

        Text("TextField")
        var tfText by remember{mutableStateOf("")}
        TextField(value = tfText, onValueChange = {tfText = it})

        var otfText by remember{mutableStateOf("")}
        TextField(value = otfText, onValueChange = {otfText = it}, label = {Text("Outlined")}, keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number))
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
        ButtonUi("Welcome to Jetpack Compose Application Development")
    }
}

@Composable
fun ComposeImages() {

    Column (Modifier.fillMaxSize()){
        Text("Vector Graphic")
        Image(painter = painterResource(id = R.drawable.android), contentDescription = "Android(TM) Bot", Modifier.fillMaxWidth())

        Text("Bitmap Graphic")
        Spacer(Modifier.height(64.dp))
        Image(painter = painterResource(id = R.drawable.flower), contentDescription = "Flower Content Description",
            Modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(CircleShape), contentScale = ContentScale.Crop)
    }

}


@Composable
fun ButtonUi(messageText: String) {
    Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){

        var message by remember{mutableStateOf("")}
        Button(onClick = { message = messageText}) {
            Text("Show Message")
        }

        Text(text = message, style = MaterialTheme.typography.titleSmall)


    }
}


//@Preview
//@Composable
//fun PreviewSimpleComposable() {
//    SimpleComposable()
//}
@Preview
@Composable
fun ButtonUiPreview() {
//    var message by remember{mutableStateOf("Welcome to Jetpack Compose Application Development")}
    ButtonUi("Welcome to Jetpack Compose Application Development")
}

@Preview
@Composable
fun NetworkImagePreview() {
    NetworkImage()
}



@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun AnimatedVisibilitySample() {
    val (checked, onCheckedChange) = remember{mutableStateOf(false)}


    val show = remember{
        MutableTransitionState(false).apply{
            targetState = true
        }
    }
    Column (
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .shadow(2.dp)){
        Row(Modifier.padding(16.dp)) {
            Checkbox(checked, onCheckedChange, enabled = checked)
            Text("Show Content")
        }

        AnimatedVisibility(visibleState = show,
            enter = fadeIn() + slideInHorizontally(initialOffsetX = {-it},
                animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy, visibilityThreshold = IntOffset(200, 100))),
            exit = shrinkOut(shrinkTowards = Alignment.BottomStart,
                animationSpec = tween(1000))) {
            Box(
                Modifier
                    .size(400.dp)
                    .padding(16.dp),
                contentAlignment = Alignment.BottomCenter
            ){
                Image(painterResource(id = R.drawable.flower), "Profile", modifier = Modifier.clip(
                    RoundedCornerShape(8.dp)
                )
                    .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Text("Jetpack Compose is awesome", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.BottomCenter)
                        .animateEnterExit(enter = slideInVertically(initialOffsetY = {2*it},
                            animationSpec = tween(1000)
                        ))
                )
            }
        }
    }
}


enum class Picture { Man, Woman, Daughter, Son, All }

/**
 * Composable to show Crossfade and AnimatedContent animations
 */
@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun AnimationDemo() {
    /**
     * Count to keep track of the horizontal sliding counter
     */
    var count by remember { mutableStateOf(0) }

    /**
     * Flag to expand or shrink the text content
     */
    var expand by remember { mutableStateOf(false) }

    /**
     * Enum variable to select a picture to crossfade to
     */
    var pick by remember { mutableStateOf(Picture.Man) }


    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .shadow(2.dp)
    ) {
        Column (
            Modifier
                .fillMaxHeight(0.4f)
                .padding(8.dp)
        ){
            Text(stringResource(id = R.string.animated_content_sample_1), Modifier.padding(8.dp))
            Divider()

            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp)
                    .background(Color.Yellow)
                ,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                IconButton(onClick = { if(count > 0) count-- },
                    modifier = Modifier
                        .weight(1f)) {
                    Icon(
                        painterResource(id = R.drawable.left_arrow), null, Modifier
                            .size(100.dp)
                    )
                }

                //Add AnimatedContent here around Box
                AnimatedContent(targetState = count,
                    transitionSpec = {
                        if(targetState > initialState) {
                            val contentTransform =
                                slideInHorizontally(animationSpec = tween(durationMillis = 200) { width -> -width }) + fadeIn() with slideOutHorizontally(animationSpec = tween(durationMillis = 200)
                                    { width -> width }) + fadeOut() using
                                        SizeTransform { initialSize, targetSize ->
                                            keyframes {
                                                durationMillis = 300
                                                IntSize(
                                                    initialSize.width / 2,
                                                    targetSize.height / 2
                                                ) at 150
                                            }
                                        }
                            contentTransform
                        }
                        else {
                            val contentTransform: ContentTransform =
                                (slideInHorizontally(animationSpec = tween(durationMillis = 200){ width -> width }) + fadeIn()) with (slideOutHorizontally(animationSpec = tween(durationMillis = 200)
                                    { width -> -width }) + fadeOut())
                            contentTransform
                        }
                    }, label = ""
                ){ targetCount ->
                    // Make sure to use `targetCount`, not `count`.
                    //Text(text = "Count: $targetCount")
                    Box(
                        Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .width(100.dp), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "$targetCount",
                            fontSize = 50.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }


                IconButton(onClick = { count++ },
                    modifier = Modifier
                        .weight(1f)) {
                    Icon(
                        painterResource(id = R.drawable.right_arrow), null, Modifier
                            .size(100.dp)
                    )
                }

            }
        }


        Column(
            Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    stringResource(id = R.string.animated_content_sample_2),
                    Modifier.padding(8.dp),
                )
                Text(stringResource(id = R.string.expand), Modifier.padding(8.dp))
                Checkbox(checked = expand, onCheckedChange = { expand = !expand })
            }
            Divider()
//            AnimatedContent(targetState = expand,
//                transitionSpec = {
//                    slideIntoContainer(towards = AnimatedContentScope.SlideDirection.Up, animationSpec =
//                    spring(Spring.DampingRatioHighBouncy)) + fadeIn() with slideOutOfContainer(
//                        AnimatedContentScope.SlideDirection.Up) + fadeOut() using
//                            SizeTransform { initialSize, targetSize ->
//                                keyframes {
//                                    durationMillis = 300
//                                    IntSize(initialSize.width, targetSize.height) at 150
//                                }
//                            }
//                }) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.LightGray)
//                ) {
//                    if (!expand) {
//                        Box(
//                            Modifier
//                                .wrapContentSize()
//
//                        ) {
//                            Text("short text", Modifier.padding(8.dp))
//                        }
//                    } else {
//                        Box(
//                            Modifier
//                                .wrapContentHeight()
//                                .fillMaxWidth()
//                        ) {
//                            Text(
//                                "Long text\nLong text line\nLong text line 3",
//                                Modifier.padding(8.dp)
//                            )
//                        }
//                    }
//                }
//            }

        }

//        Column(
//            modifier = Modifier
//                .fillMaxHeight()
//                .fillMaxWidth()
//                .padding(8.dp)
//
//        ) {
//
//            Text(stringResource(id = R.string.crossfade_animation_sample), Modifier.padding(8.dp),
//                style = MaterialTheme.typography.h6)
//            Divider()
//
//
//            val targetState = pick
//
//            Crossfade(targetState = pick,
//                animationSpec = tween(durationMillis = 1000,
//                    easing = LinearEasing)) {picture ->
//                Box(
//                    Modifier
//                        .fillMaxSize()
//                        .clickable {
//                            val items = Picture.values()
//                            val nextItem =
//                                if (picture.ordinal < items.size - 1) items[picture.ordinal + 1] else items[0]
//                            pick = nextItem
//                        }) {
//                    Text(
//                        targetState.name,
//                        Modifier
//                            .align(Alignment.TopEnd)
//                            .padding(8.dp),
//                        fontSize = 30.sp, fontWeight = FontWeight.Bold
//                    )
//                    when (targetState) {
//                        Picture.Man -> {
//                            Image(painterResource(id = R.drawable.professor), null)
//                        }
//
//                        Picture.Woman -> {
//                            Image(painterResource(id = R.drawable.woman), null)
//
//                        }
//
//                        Picture.Daughter -> {
//                            Image(painterResource(id = R.drawable.daughter), null)
//                        }
//
//                        Picture.Son -> {
//                            Image(painterResource(id = R.drawable.son), null)
//                        }
//
//                        Picture.All -> {
//                            Row(Modifier.fillMaxSize()) {
//                                val pics = listOf(
//                                    R.drawable.professor, R.drawable.woman,
//                                    R.drawable.daughter, R.drawable.son
//                                )
//                                for (pic in pics)
//                                    Image(
//                                        painterResource(id = pic),
//                                        null,
//                                        Modifier
//                                            .weight(1f)
//                                            .align(Alignment.Bottom)
//                                            .graphicsLayer {
//                                                if (pic == R.drawable.professor) rotationY = 180f
//                                            }
//                                    )
//                            }
//                        }
//                    }
//                }
//            }
//
//        }

    }
}