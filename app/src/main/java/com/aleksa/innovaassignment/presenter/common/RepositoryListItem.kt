package com.aleksa.innovaassignment.presenter.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aleksa.innovaassignment.R
import com.aleksa.innovaassignment.model.RepositoryItem


@Composable
fun RepositoryListItem(
    repositoryItem: RepositoryItem?,
    navigateToDetails: (RepositoryItem) -> Unit
) {
    if (repositoryItem != null) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp, top = 8.dp, bottom = 8.dp)
                .clickable { navigateToDetails(repositoryItem) },
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
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.padding(bottom = 5.dp)
                ) {
                    Text(text = stringResource(R.string.repository_name),
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp)
                    Text(
                        text = repositoryItem.name,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )

                }
                Column(modifier = Modifier.padding(bottom = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(R.string.issues_opened),
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp)
                    Text(
                        text = repositoryItem.open_issues_count.toString(),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.SemiBold

                    )
                }
            }
        }
    }
}


