package com.example.iroiro_test.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.iroiro_test.R

class MainFragment : Fragment() {

    private val labelChangeButtonClickListener = {_: View ->
        this@MainFragment.view!!.findViewById<TextView>(R.id.textView).text = "aaabbbxxx"
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        view!!.findViewById<Button>(R.id.labelChangeButton).setOnClickListener(labelChangeButtonClickListener)
    }


}
