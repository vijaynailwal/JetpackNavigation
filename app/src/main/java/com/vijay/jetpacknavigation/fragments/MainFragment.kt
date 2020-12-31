package com.vijay.jetpacknavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.vijay.jetpacknavigation.R

class MainFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_fragmenta).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_fragmentb).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_fragmentc).setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_fragmenta -> {
                navController.navigate(R.id.action_mainFragment_to_fragmentA)
            }
            R.id.btn_fragmentb -> {
                navController.navigate(R.id.action_mainFragment_to_fragmentB)
            }
            R.id.btn_fragmentc -> {
                navController.navigate(R.id.action_mainFragment_to_fragmentC)
            }
        }
    }
}