/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

private const val START_TOP_PADDING = 160

@Composable
fun PuppyDetails(puppy: Puppy, modifier: Modifier = Modifier) {
    val context = LocalContext.current as? Activity
    val scrollState = rememberScrollState()

    val imagePadding = (-scrollState.value * 0.2f).dp
    val iconBackgroundAlpha = ((scrollState.value / START_TOP_PADDING.toFloat()) * 0.2f).coerceAtMost(0.2f)

    Box {
        Image(
            painter = painterResource(id = puppy.resId),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .offset(y = imagePadding)
                .height(200.dp)
                .fillMaxWidth()
        )

        Column(
            Modifier
                .verticalScroll(scrollState)
                .padding(top = START_TOP_PADDING.dp)
                .background(
                    MaterialTheme.colors.surface,
                    RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(all = 32.dp)
        ) {
            Text("Hello my name is", style = MaterialTheme.typography.h6)
            Text(text = puppy.name, style = MaterialTheme.typography.h3)
            Spacer(Modifier.size(16.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Detail("Breed 🐶", "Spoodle")
                Detail("Weight ⚖️", "8 kg")
                Detail("Sex ⚤", detail = "Female")
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "${puppy.name} is a lively 12 week old Spoodle. She is very playful, friendly and gentle. She would be great with little children.\n\n$LORIM")
        }

        IconButton(onClick = { context?.onBackPressed() }, modifier = Modifier.padding(8.dp).background(Color.Black.copy(alpha = iconBackgroundAlpha), shape = CircleShape)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back_24),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
private fun Detail(heading: String, detail: String, modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(heading, style = MaterialTheme.typography.h6)
        Text(detail, style = MaterialTheme.typography.subtitle1)
    }
}

@Preview
@Composable
private fun PuppyPreview() {
    MyTheme {
        PuppyDetails(puppy = PuppyRepo.puppies.first())
    }
}

private const val LORIM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nulla ipsum, dignissim ut finibus eu, ultricies non velit. Mauris pharetra leo ligula, eget consequat ipsum suscipit molestie. Cras diam orci, imperdiet et sem in, pharetra euismod nunc. Nullam placerat odio mollis dignissim lacinia. Etiam odio lorem, interdum eu fermentum ut, hendrerit sed orci. Integer non cursus ligula. Ut bibendum turpis sit amet placerat ullamcorper. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque dolor mi, consectetur ut justo at, venenatis aliquam nisl. Donec congue lacus non ipsum luctus, vitae finibus dolor suscipit. Aenean sed lectus porta, ullamcorper quam non, pulvinar sem. Sed lectus lorem, cursus eget vestibulum id, volutpat non felis. Sed pulvinar, justo non finibus consectetur, nunc sem convallis sapien, a scelerisque massa elit eget ex.\n" +
    "\n" +
    "Vestibulum feugiat neque faucibus risus bibendum pulvinar. Nulla viverra mi at risus egestas fermentum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Proin facilisis arcu ut commodo pulvinar. Sed dapibus nisi ac mi accumsan mollis. Integer id sagittis sem, a dictum libero. Sed eget aliquet nisi. Fusce venenatis pulvinar elementum. Suspendisse in nibh scelerisque, lobortis sapien sed, tempor nunc. Sed vitae faucibus tortor. Donec finibus enim et porta consectetur."
