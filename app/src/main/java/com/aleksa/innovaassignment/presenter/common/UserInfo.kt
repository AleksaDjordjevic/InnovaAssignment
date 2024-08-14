package com.aleksa.innovaassignment.presenter.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aleksa.innovaassignment.R
import com.aleksa.innovaassignment.model.RepositoryItem

@Composable
fun UserInfo(
    repositoryItem: RepositoryItem?,
) {

    val context = LocalContext.current

    if (repositoryItem != null) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            GlowingCard(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(20.dp),
                glowingColor = colorResource(id = R.color.teal_700),
                containerColor = colorResource(id = R.color.teal_700),
                cornersRadius = 10.dp
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = repositoryItem.owner.login,
                            color = Color.Black,
                            fontSize = 21.sp,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Text(
                            text = repositoryItem.name,
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        IconText(
                            painter = painterResource(id = R.drawable.ic_fork),
                            text = repositoryItem.forks_count.toString()
                        )
                        IconText(
                            painter = painterResource(id = R.drawable.ic_watcher),
                            text = repositoryItem.watchers_count.toString()
                        )


                    }
                    AsyncImage(
                        modifier = Modifier
                            .padding(20.dp)
                            .size(90.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        model = ImageRequest.Builder(context).data(repositoryItem.owner.avatar_url)
                            .crossfade(true).build(),
                        contentDescription = null,
                        contentScale = ContentScale.Inside,
                        error = painterResource(R.drawable.ic_user_placeholder),

                        )
                }
            }
        }
    }
}

@Composable
fun IconText(
    painter: Painter,
    text: String
) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier.padding(end = 5.dp),
            painter = painter,
            contentDescription = text,
            tint = Color.White

        )
        Text(
            text = text,
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Normal,
        )

    }
}

