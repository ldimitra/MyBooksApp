package com.ldimitra.mybooksapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ldimitra.mybooksapp.databinding.BookLayoutItemBinding
import com.ldimitra.mybooksapp.domain.model.BookDetails

class BookAdapter(private val onBookItemClickListener: OnBookItemClickListener) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    private var bookList = emptyList<BookDetails>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            BookLayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.book = bookList[position]
        holder.binding.clickListener = onBookItemClickListener
    }

    inner class ViewHolder(val binding: BookLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun setBookList(bookList: List<BookDetails>) {
        this.bookList = bookList
        notifyDataSetChanged()
    }
}