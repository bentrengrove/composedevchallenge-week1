package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyView(puppy: Puppy, modifier: Modifier = Modifier) {
    Card(modifier, shape = RoundedCornerShape(16.dp)) {
        Box {
            Image(
                painterResource(puppy.resId),
                null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Box(modifier = Modifier
                .align(Alignment.BottomStart)
                .background(Brush.verticalGradient(listOf(Color.Transparent, MaterialTheme.colors.onSurface)))
                .fillMaxWidth()
                .padding(16.dp)) {
                Text(text = puppy.name, style = MaterialTheme.typography.h5, color = MaterialTheme.colors.surface)
            }
        }
    }
}

@Preview
@Composable
private fun PuppyPreview() {
    MyTheme {
        PuppyView(puppy = PuppyRepo.puppies.first())
    }
}