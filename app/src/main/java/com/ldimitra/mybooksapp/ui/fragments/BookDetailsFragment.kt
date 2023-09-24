package com.ldimitra.mybooksapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.ldimitra.mybooksapp.R
import com.ldimitra.mybooksapp.databinding.FragmentBookDetailsBinding
import com.ldimitra.mybooksapp.ui.viewModels.BookDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailsFragment : Fragment() {
    private lateinit var binding: FragmentBookDetailsBinding
    private lateinit var viewModel: BookDetailsViewModel
    private val args: BookDetailsFragmentArgs by navArgs()

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this)[BookDetailsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_book_details, container, false)
        initializeViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.getBookById(args.bookId)
        return binding.root
    }
}