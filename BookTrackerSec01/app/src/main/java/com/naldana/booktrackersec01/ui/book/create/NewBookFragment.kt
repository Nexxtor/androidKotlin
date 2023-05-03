package com.naldana.booktrackersec01.ui.book.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.textfield.TextInputLayout
import com.naldana.booktrackersec01.R
import com.naldana.booktrackersec01.databinding.FragmentNewBookBinding

class NewBookFragment : Fragment() {

    private lateinit var binding: FragmentNewBookBinding
    private val viewModel: NewBookViewModel by viewModels {
        NewBookViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_new_book,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.statusError.observe(viewLifecycleOwner) { status ->
            when (status) {
                is StatusNewBook.Error -> {
                    val error = status.errors
                    error.forEach {
                        val fieldBook = it.first
                        val errors = it.second
                        when(fieldBook) {
                            FieldBook.TITLE -> {
                                setError(binding.titleBook,errors)
                            }
                            FieldBook.PAGE_COUNT -> TODO()
                            FieldBook.SUBJECT -> TODO()
                            FieldBook.SUMMARY -> TODO()
                            FieldBook.ISBN -> TODO()
                        }
                    }
                }

                StatusNewBook.Init -> {
                    binding.titleBook.error = null
                    binding.pageCountBook.error = null
                    binding.isbnBook.error = null
                    binding.subjectBook.error = null
                    binding.summaryBook.error = null
                }
            }
        }
    }

    private fun setError(titleBook: TextInputLayout, errors: List<TypeError>) {
        errors.forEach {
            titleBook.error =  when(it){
                TypeError.Required -> getString(R.string.error_required)
                TypeError.BadFormat -> "Bad format"
            }
        }
    }

}