package com.aleksa.innovaassignment.presenter.screens.repositories

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
import com.aleksa.innovaassignment.presenter.common.RepositoryListItem

@Composable
fun RepositoriesScreen(
    repoList: List<RepositoryItem>?,
    onRepoItemClick: (repositoryItem: RepositoryItem) -> Unit,
) {
    if (repoList != null) {
        if (repoList.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        start = 10.dp,
                        end = 10.dp
                    ),
                contentPadding = PaddingValues(vertical = 8.dp),
            ) {

                items(count = repoList.size) { repoItem ->
                    RepositoryListItem(
                        repositoryItem = repoList[repoItem],
                        navigateToDetails = { onRepoItemClick(it) }
                    )
                }
            }
        } else {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 45.dp), text = stringResource(R.string.no_repositories),
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

