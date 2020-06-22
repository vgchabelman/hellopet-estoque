package br.com.hellopetdesign.presentation.utils

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract fun screenName(): String

    override fun onResume() {
        super.onResume()

        activity?.title = screenName()
    }
}