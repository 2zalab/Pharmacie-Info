package com.sintel.infopharmaciemaroua.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.Snapshot.Companion.current
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import com.sintel.infopharmaciemaroua.R
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ImageSlider() {
    val images = listOf(
        R.drawable.to_pharma,
        R.drawable.pharma3,
        R.drawable.pharma1,
        R.drawable.pharma2
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            val infiniteTransition = rememberInfiniteTransition()
            val xPosition by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = -100f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 4000, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )

            Image(
                painter = painterResource(id = images[currentIndex]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .offset(xPosition.dp, 0.dp)
            )

            Image(
                painter = painterResource(id = images[getNextIndex(currentIndex, images)]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .offset((xPosition + 100).dp, 0.dp)
            )

            Image(
                painter = painterResource(id = images[getPreviousIndex(currentIndex, images)]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .offset((xPosition - 100).dp, 0.dp)
            )

            PagerIndicator(
                count = images.size,
                currentIndex = currentIndex,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }

    LaunchedEffect(currentIndex) {
        delay(3000)
        currentIndex = getNextIndex(currentIndex, images)
    }
}

fun getNextIndex(currentIndex: Int, images: List<Int>): Int {
    return if (currentIndex == images.lastIndex) 0 else currentIndex + 1
}

fun getPreviousIndex(currentIndex: Int, images: List<Int>): Int {
    return if (currentIndex == 0) images.lastIndex else currentIndex - 1
}

@Composable
fun PagerIndicator(
    count: Int,
    currentIndex: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = MyColors.primary,//MaterialTheme.colors.primary,
    inactiveColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.4f),
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        for (i in 0 until count) {
            val color = if (i == currentIndex) activeColor else inactiveColor
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(color)
                    .padding(2.dp)
            )
        }
    }
}

@Preview
@Composable
fun PrevieuwSlider()
{
    ImageSlider()
}

/*
val imageList = listOf(
    R.drawable.to_pharma,
    R.drawable.pharmacie,
    R.drawable.pharma1
)

@Composable
fun AutomaticImageSlider() {
    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000L)
            currentIndex = (currentIndex + 1) % imageList.size
            // Scroll to the next image
            // We calculate the index of the next image, and use the `scroll` method
            // on the LazyRow to smoothly scroll to it over a duration of 500ms
            val nextIndex = (currentIndex + 1) % imageList.size
            val itemWidth = 200.dp//LocalDensity.current.run { 200.dp.toPx() } // item width = 200dp
            val scrollDistance = (nextIndex - currentIndex) //* itemWidth
            val scrollDuration = 500 // in milliseconds
            (0 until scrollDuration step 16).forEach { time ->
                delay(16)
                val fraction = time.toFloat() / scrollDuration.toFloat()
                val offset = fraction * scrollDistance
                val currentOffset = current//current.offset.value
                //current.offset.animateTo(currentOffset + offset.toInt())
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            // Display the image
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            ) {
                itemsIndexed(items = imageList) { index, image ->
                    Surface(
                        modifier = Modifier
                            .height(200.dp)
                            .aspectRatio(1f),
                        elevation = 4.dp,
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = "Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            // Display the indicator
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
            ) {
                repeat(imageList.size) { index ->
                    Box(
                        modifier = Modifier
                            .size(if (currentIndex == index) 10.dp else 6.dp)
                            .background(
                                if (currentIndex == index) Color.White
                                else Color.Gray
                            )
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}

 */