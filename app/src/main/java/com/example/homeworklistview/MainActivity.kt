package com.example.homeworklistview

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homeworklistview.ui.theme.HomeworkListViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeworkListViewTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.White
                ) {


                    LazyColumn() {
                        item {
                            Post()
                        }
                        item {
                            Post()
                        }
                        item {
                            Post()
                        }
                        item {
                            Post()
                        }
                        item {
                            Post()
                        }
                        item {
                            Post()
                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Post() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp)
            .background(color = Color.White)
    ) {
        UserTitle()
        Text(
            text = "Without further interruption, let's celebrate!", modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.test_post_picture),
            contentDescription = "'s post picture",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = Color(250, 250, 250)),
            contentScale = ContentScale.FillWidth
        )
        ReactionBar()

    }
}

@Composable
fun UserTitle() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(35.dp)
                .clip(RoundedCornerShape(15.dp)),
        ) {
            Image(
                painter = painterResource(id = R.drawable.test_profile_picture),
                "'s profilePhoto",
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = "Billy Herrington",
            modifier = Modifier.padding(horizontal = 10.dp),
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif
        )
    }

}


@Preview
@Composable
fun ReactionBar() {

    var likeStatus by remember { mutableStateOf(false) }

    var likeQuantity by remember { mutableStateOf((Math.random()*100).toInt()) }

    var isChanged by remember {
        mutableStateOf(false)
    }

    val mContext = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp)
    ) {
        Button(
            onClick = {
                likeStatus = !likeStatus
                isChanged = !isChanged
                if (isChanged) {
                    likeQuantity++
                } else {
                    likeQuantity--
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color.LightGray),
        ) {

            if (likeStatus) {
                Image(
                    painter = painterResource(id = R.drawable.liked),
                    contentDescription = "Like image"
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.unliked),
                    contentDescription = "Like image"
                )
            }

            Text(
                text = "$likeQuantity",
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 2.dp)
            )

        }

        Button(
            onClick = {
                val i = Intent(mContext, CommentActivity::class.java)
                mContext.startActivity(i)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color.LightGray),
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.chatroom),
                contentDescription = "Chatroom image"
            )
        }


        Button(
            onClick = {
                Toast.makeText(mContext, "Reposted!", Toast.LENGTH_LONG).show()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color.LightGray),
        ) {

            Image(
                painter = painterResource(id = R.drawable.repost),
                contentDescription = "Repost image"
            )
        }

    }

}