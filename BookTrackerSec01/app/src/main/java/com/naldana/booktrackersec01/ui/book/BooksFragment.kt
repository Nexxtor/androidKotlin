package com.naldana.booktrackersec01.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.naldana.booktrackersec01.R
import com.naldana.booktrackersec01.databinding.FragmentBooksBinding

class BooksFragment : Fragment() {

    private lateinit var binding: FragmentBooksBinding
    private val viewModel: BooksViewModel by viewModels {
        BooksViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_books, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBooks()
    }

}