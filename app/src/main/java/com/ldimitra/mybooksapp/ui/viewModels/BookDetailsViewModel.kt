package com.ldimitra.mybooksapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ldimitra.mybooksapp.domain.DomainResult
import com.ldimitra.mybooksapp.domain.usecase.GetBookDetailsUseCase
import com.ldimitra.mybooksapp.domain.model.BookDetails
import com.ldimitra.mybooksapp.ui.utils.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookDetailsViewModel @Inject constructor(private val getBookDetailsUseCase: GetBookDetailsUseCase) : ViewModel() {
    private val _bookDetails = MutableStateFlow<BookDetails?>(null)
    val bookDetails: StateFlow<BookDetails?> = _bookDetails

    private val _screenState = MutableStateFlow(ScreenState.LOADING)
    val screenState: StateFlow<ScreenState> = _screenState

    fun getBookById(bookId: Int) {
        viewModelScope.launch {
            _screenState.value = ScreenState.LOADING
            when (val response = getBookDetailsUseCase(bookId)) {
                is DomainResult.Success -> {
                    _bookDetails.value = response.data
                    _screenState.value = ScreenState.CONTENT
                }

                is DomainResult.Error -> {
                    _screenState.value = ScreenState.ERROR
                }

                is DomainResult.Exception -> {
                    _screenState.value = ScreenState.ERROR
                }
            }
        }
    }
}