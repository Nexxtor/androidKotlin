package com.naldana.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf

private const val ARG_NAME = "ARG_NAME"
private const val ARG_LASTNAME = "ARG_LASTNAME"

/**
 * A simple [Fragment] subclass.
 * Use the [GreetingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GreetingFragment : Fragment() {
    private var name: String? = null
    private var lastName: String? = null

    private lateinit var greetingTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            lastName = it.getString(ARG_LASTNAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(
        R.layout.fragment_greeting,
        container, false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        greetingTextView = view.findViewById(R.id.greeting_text_view)
        greetingTextView.text = getString(R.string.text_name_lastname,
            name ?: "Nestor", lastName ?: "Aldana")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param name Parameter 1.
         * @param lastName Parameter 2.
         * @return A new instance of fragment GreetingFragment.
         */
        @JvmStatic
        fun newInstance(name: String, lastName: String) =
            GreetingFragment().apply {
               /* arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_LASTNAME, lastName)
                }*/

                arguments = bundleOf(
                    ARG_NAME to name,
                    ARG_LASTNAME to lastName
                )
            }


    }
}