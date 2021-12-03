package com.example.viewmodelexample.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.viewmodelexample.databinding.FragmentAccountBinding
import com.google.android.material.textfield.TextInputLayout

class AccountFragment : Fragment() {
    private val binding by lazy { FragmentAccountBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()
        init()
        return binding.root
    }

    private fun init() {
        binding.btnLogin.setOnClickListener {
            binding.apply {
                val username = usernameEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (validateUsername(username, usernameInputLayout) &&
                    validatePassword(password, passwordInputLayout)
                ) {
                    val action =
                        AccountFragmentDirections.actionAccountFragmentToAccountInfoFragment()
                    findNavController().navigate(action)
                }
            }
        }
    }

    private fun validateUsername(inputText: String, textInputLayout: TextInputLayout): Boolean {
        return if (inputText.length <= 4) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error = "* Minimum 5 Characters Allowed"
            false
        } else {
            textInputLayout.isErrorEnabled = false
            textInputLayout.error = null
            true
        }
    }

    private fun validatePassword(inputText: String, textInputLayout: TextInputLayout): Boolean {
        return if (inputText.length <= 7) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error = "* Minimum 8 Characters Allowed"
            false
        } else {
            textInputLayout.isErrorEnabled = false
            textInputLayout.error = null
            true
        }
    }
}
