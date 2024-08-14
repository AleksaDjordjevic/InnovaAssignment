package com.aleksa.innovaassignment.presenter.screens.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleksa.innovaassignment.data.repository.GitHubRepository
import com.aleksa.innovaassignment.model.RepositoryTag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryDetailsViewModel @Inject constructor(private val repository: GitHubRepository) :
    ViewModel() {

    private var _repositoryTagsList = MutableLiveData<List<RepositoryTag>?>()
    var repositoryTagsList: LiveData<List<RepositoryTag>?> = _repositoryTagsList


    fun getRepositoryTags(repoName: String) {
        viewModelScope.launch {
            val repositoriesResponse = repository.getTags(repoName)
            when (repositoriesResponse.isSuccessful) {
                true -> {
                    _repositoryTagsList.value = repositoriesResponse.body()
                    Log.d("ResponseTagsList", repositoryTagsList.value?.size.toString())

                }
                else -> {
                    Log.e("ErrorTagsList", repositoriesResponse.message())
                }
            }
        }
    }
}