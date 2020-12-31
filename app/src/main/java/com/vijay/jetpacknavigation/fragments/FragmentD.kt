package com.vijay.jetpacknavigation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.vijay.jetpacknavigation.R
import com.vijay.jetpacknavigation.model.MoneyModel
import kotlinx.android.synthetic.main.fragment_b.*

class FragmentD : Fragment(), View.OnClickListener {
      lateinit var receive_data: String
//    lateinit var moneyModel: MoneyModel
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        receive_data= requireArguments().getString("send_data_key").toString()
//        moneyModel = requireArguments().getParcelable("send_data_key")!!
        return inflater.inflate(R.layout.fragment_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_fragmente).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_cancel).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv_receivedata).text=receive_data
//        view.findViewById<TextView>(R.id.tv_receivedata).text = moneyModel.amount.toString()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_fragmente -> {
                navController.navigate(R.id.action_fragmentD_to_fragmentE)
            }
            R.id.btn_cancel -> {
                val bundle = bundleOf("send_data_key" to receive_data)//send string
                navController.navigate(R.id.action_fragmentD_to_fragmentB, bundle)
//                activity?.onBackPressed()
            }
        }
    }
}