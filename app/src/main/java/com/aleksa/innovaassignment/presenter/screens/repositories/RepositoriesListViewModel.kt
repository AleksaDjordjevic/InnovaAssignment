package com.aleksa.innovaassignment.presenter.screens.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleksa.innovaassignment.data.repository.GitHubRepository
import com.aleksa.innovaassignment.model.RepositoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesListViewModel @Inject constructor(private val repository: GitHubRepository) :
    ViewModel() {

    private var _repositoryList = MutableLiveData<List<RepositoryItem>?>()
    var repositoryList: LiveData<List<RepositoryItem>?> = _repositoryList

    init {
        getRepositories()
    }

    private fun getRepositories() {
        viewModelScope.launch {
            val repositoriesResponse = repository.getRepositories()
            when (repositoriesResponse.isSuccessful) {
                true -> {
                    _repositoryList.value = repositoriesResponse.body()
                    Log.d("ResponseRepository", repositoryList.value?.size.toString())

                }
                else -> {
                    Log.e("ErrorRepositoryList", repositoriesResponse.message())
                }
            }
        }
    }
}