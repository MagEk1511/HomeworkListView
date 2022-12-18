package com.example.homeworklistview

import androidx.compose.foundation.Image
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Video
import android.util.Size
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size.Companion.ORIGINAL


class CommentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(
                modifier = Modifier.padding(5.dp),
            ) {

                item {
                    Text(
                        text = "We're no strangers to love\n" +
                                "You know the rules and so do I (do I)\n" +
                                "A full commitment's what I'm thinking of\n" +
                                "You wouldn't get this from any other guy\n" +
                                "\n" +
                                "I just wanna tell you how I'm feeling\n" +
                                "Gotta make you understand\n" +
                                "\n" +
                                "Never gonna give you up\n" +
                                "Never gonna let you down\n" +
                                "Never gonna run around and desert you\n" +
                                "Never gonna make you cry\n" +
                                "Never gonna say goodbye\n" +
                                "Never gonna tell a lie and hurt you\n" +
                                "\n" +
                                "We've known each other for so long\n" +
                                "Your heart's been aching, but you're too shy to say it (say it)\n" +
                                "Inside, we both know what's been going on (going on)\n" +
                                "We know the game and we're gonna play it\n" +
                                "\n" +
                                "And if you ask me how I'm feeling\n" +
                                "Don't tell me you're too blind to see\n" +
                                "\n" +
                                "Never gonna give you up\n" +
                                "Never gonna let you down\n" +
                                "Never gonna run around and desert you\n" +
                                "Never gonna make you cry\n" +
                                "Never gonna say goodbye\n" +
                                "Never gonna tell a lie and hurt you\n" +
                                "\n" +
                                "Never gonna give you up\n" +
                                "Never gonna let you down\n" +
                                "Never gonna run around and desert you\n" +
                                "Never gonna make you cry\n" +
                                "Never gonna say goodbye\n" +
                                "Never gonna tell a lie and hurt you\n" +
                                "\n" +
                                "(Ooh, give you up)\n" +
                                "(Ooh, give you up)\n" +
                                "(Ooh) Never gonna give, never gonna give (give you up)\n" +
                                "(Ooh) Never gonna give, never gonna give (give you up)\n" +
                                "\n" +
                                "We've known each other for so long\n" +
                                "Your heart's been aching, but you're too shy to say it (to say it)\n" +
                                "Inside, we both know what's been going on (going on)\n" +
                                "We know the game and we're gonna play it\n" +
                                "\n" +
                                "I just wanna tell you how I'm feeling\n" +
                                "Gotta make you understand\n" +
                                "\n" +
                                "Never gonna give you up\n" +
                                "Never gonna let you down\n" +
                                "Never gonna run around and desert you\n" +
                                "Never gonna make you cry\n" +
                                "Never gonna say goodbye\n" +
                                "Never gonna tell a lie and hurt you\n" +
                                "\n" +
                                "Never gonna give you up\n" +
                                "Never gonna let you down\n" +
                                "Never gonna run around and desert you\n" +
                                "Never gonna make you cry\n" +
                                "Never gonna say goodbye\n" +
                                "Never gonna tell a lie and hurt you\n" +
                                "\n" +
                                "Never gonna give you up\n" +
                                "Never gonna let you down\n" +
                                "Never gonna run around and desert you\n" +
                                "Never gonna make you cry\n" +
                                "Never gonna say goodbye\n" +
                                "Never gonna tell a lie and hurt you",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                item {
                    GifImage()
                }
            }
        }
    }

    @Composable
    fun GifImage(
        modifier: Modifier = Modifier,
    ) {
        val context = LocalContext.current
        val imageLoader = ImageLoader.Builder(context)
            .components {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context).data(data = R.drawable.rick).apply(block = {
                    size(ORIGINAL)
                }).build(), imageLoader = imageLoader
            ),
            contentDescription = null,
            modifier = modifier.fillMaxWidth(),
        )
    }
}