package com.naldana.shareviewmodel.ui.name

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.naldana.shareviewmodel.R
import com.naldana.shareviewmodel.ui.MainViewModel

/**
 * Form to ask name of user
 * Use the [NameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NameFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var saveButton: Button
    private lateinit var nameEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        addListener()
        if (viewModel.name.isNotEmpty()) nameEditText.setText(viewModel.name)
    }

    private fun addListener() {
        saveButton.setOnClickListener {
            viewModel.name = nameEditText.text.toString()
        }
    }

    private fun bind(view: View) {
        saveButton = view.findViewById(R.id.action_save)
        nameEditText = view.findViewById(R.id.name_edit_text)
    }
}