package com.aleksa.innovaassignment.presenter.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aleksa.innovaassignment.R
import com.aleksa.innovaassignment.model.RepositoryTag

@Composable
fun TagListItem(
    tagItem: RepositoryTag?,
) {
    if (tagItem != null) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp, top = 8.dp, bottom = 8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            shape = RoundedCornerShape(
                topStart = 7.dp,
                bottomStart = 7.dp,
                bottomEnd = 7.dp,
                topEnd = 7.dp
            ),
        ) {

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.tag_name),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
                Text(
                    text = tagItem.name,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )

                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = stringResource(R.string.sha),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
                Text(
                    text = tagItem.commit.sha,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold

                )
            }
        }
    }
}
