package com.ldimitra.mybooksapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ldimitra.mybooksapp.domain.DomainResult
import com.ldimitra.mybooksapp.domain.model.BookDetails
import com.ldimitra.mybooksapp.domain.usecase.GetBooksUseCase
import com.ldimitra.mybooksapp.ui.utils.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val getBooksUseCase: GetBooksUseCase) :
    ViewModel() {
    private val _books = MutableStateFlow<List<BookDetails>>(emptyList())
    val books = _books.asStateFlow()

    private val _screenState = MutableStateFlow(ScreenState.CONTENT)
    val screenState: StateFlow<ScreenState> = _screenState

    private val _itemClicked = MutableSharedFlow<Int>(replay = 0)
    val itemClicked = _itemClicked.asSharedFlow()

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            _screenState.value = ScreenState.LOADING
            when (val response = getBooksUseCase()) {
                is DomainResult.Success -> {
                    _books.value = response.data.bookDetails
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

    fun handleClick(bookId: Int) {
        viewModelScope.launch {
            _itemClicked.emit(bookId)
        }
    }
}