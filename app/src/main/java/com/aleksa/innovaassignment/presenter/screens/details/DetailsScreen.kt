package com.aleksa.innovaassignment.presenter.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aleksa.innovaassignment.R
import com.aleksa.innovaassignment.model.RepositoryItem
import com.aleksa.innovaassignment.model.RepositoryTag
import com.aleksa.innovaassignment.presenter.common.TagListItem
import com.aleksa.innovaassignment.presenter.common.UserInfo

@Composable
fun DetailsScreen(
    repositoryItem: RepositoryItem,
    tagsList: List<RepositoryTag>?,
) {
    Column(
        modifier = Modifier
            .padding(top = 10.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    start = 10.dp,
                    end = 10.dp
                ),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            item {
                UserInfo(repositoryItem = repositoryItem)
            }
            if (tagsList != null) {
                if (tagsList.isNotEmpty()) {
                    items(count = tagsList.size) { tagItem ->
                        TagListItem(
                            tagItem = tagsList[tagItem],
                        )
                    }
                } else {
                    item {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 45.dp),
                            text = stringResource(R.string.no_tags_for_this_repositories),
                            textAlign = TextAlign.Center,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

        }
    }
}