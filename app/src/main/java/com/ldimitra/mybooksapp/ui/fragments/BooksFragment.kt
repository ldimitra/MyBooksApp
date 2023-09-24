package com.ldimitra.mybooksapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ldimitra.mybooksapp.R
import com.ldimitra.mybooksapp.databinding.FragmentBooksBinding
import com.ldimitra.mybooksapp.ui.adapter.BookAdapter
import com.ldimitra.mybooksapp.ui.adapter.OnBookItemClickListener
import com.ldimitra.mybooksapp.ui.viewModels.BooksViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BooksFragment : Fragment(), OnBookItemClickListener {
    private lateinit var binding: FragmentBooksBinding
    private lateinit var viewModel: BooksViewModel
    private lateinit var bookAdapter: BookAdapter

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this)[BooksViewModel::class.java]
    }

    private fun prepareRecyclerView() {
        bookAdapter = BookAdapter(this)
        binding.booksRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.booksRecyclerView.adapter = bookAdapter
    }

    private fun addObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.books.collect {
                bookAdapter.setBookList(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.itemClicked.collect {
                findNavController().navigate(
                    BooksFragmentDirections.actionBooksFragmentToBookDetailsFragment(it)
                )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_books, container, false)
        initializeViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        prepareRecyclerView()
        addObservers()
        return binding.root
    }

    override fun onItemClick(bookDetailsId: Int) {
        viewModel.handleClick(bookDetailsId)
    }
}