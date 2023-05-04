package com.naldana.booktrackersec02.ui.books.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.naldana.booktrackersec02.R
import com.naldana.booktrackersec02.databinding.FragmentFormBookBinding

class FormBookFragment : Fragment() {

    private lateinit var binding: FragmentFormBookBinding
    private val viewModel: FormBookViewModel by viewModels {
        FormBookViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_form_book, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.status.observe(viewLifecycleOwner) { status ->
             when (status) {
                is StatusFromBook.Error -> {
                    status.errors.forEach {
                        when(it.key) {
                            FieldBook.TITLE -> binding.titleEditText.error = makeFullStringMessage(it.value)
                            FieldBook.SUMMARY -> TODO()
                            FieldBook.ISBN -> binding.isbnEditText.error = makeFullStringMessage(it.value)
                        }
                    }

                }
                StatusFromBook.Init -> {
                    with(binding) {
                        titleEditText.error = null
                        summaryEditText.error = null
                    }
                }
            }
        }
    }

    private fun getErrorString(type: TypeError): String {
        return when (type) {
            TypeError.REQUIERED -> getString(R.string.required_value)
            TypeError.BADFORMAT -> getString(R.string.text_formato_invalido)
        }
    }

    private fun makeFullStringMessage(errors: List<TypeError>) = errors.map {
        getErrorString(it)
    }.reduce { acc, s -> "$acc\n $s" }


}