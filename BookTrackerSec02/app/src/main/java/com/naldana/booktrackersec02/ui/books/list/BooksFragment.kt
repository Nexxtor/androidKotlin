package com.naldana.booktrackersec02.ui.books.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.naldana.booktrackersec02.R
import com.naldana.booktrackersec02.databinding.FragmentBooksBinding

class BooksFragment : Fragment() {

    private lateinit var binding: FragmentBooksBinding
    private val viewModel: BooksViewModel by viewModels {
        BooksViewModel.Factory
    }
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_books,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        val adapter = BooksAdapter { book ->
           // TODO Open detail fragment of book
        }

        viewModel.getBooks().observe(viewLifecycleOwner) { books ->
            adapter.submitData(books)
        }

        binding.addBook.setOnClickListener {
            navController.navigate(R.id.action_booksFragment_to_formBookFragment2)
        }

        binding.recyclerBooks.adapter = adapter


    }
}