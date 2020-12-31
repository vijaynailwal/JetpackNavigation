package com.vijay.jetpacknavigation.fragments

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.vijay.jetpacknavigation.R
import com.vijay.jetpacknavigation.model.MoneyModel
import kotlinx.android.synthetic.main.fragment_b.*
import java.math.BigDecimal

class FragmentB : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var getString: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_fragmentD).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_cancel).setOnClickListener(this)
        view.findViewById<EditText>(R.id.edt_sendData)
        view.findViewById<Button>(R.id.btn_sendData).setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()
        if (requireArguments().getString("send_data_key")?.isNotEmpty() == true) {
            getString = requireArguments().getString("send_data_key")!!
            view?.findViewById<TextView>(R.id.tv_receivedata)?.text = getString
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_fragmentD -> {
                navController.navigate(R.id.action_fragmentB_to_fragmentD)
            }
            R.id.btn_sendData -> {
                if (!TextUtils.isEmpty(edt_sendData.text.toString())) {
//                    val moneyModel = MoneyModel(BigDecimal(edt_sendData.text.toString()))//send model
//                    val bundle = bundleOf("send_data_key" to moneyModel)

                    val bundle =
                        bundleOf("send_data_key" to edt_sendData.text.toString())//send string
                    navController.navigate(R.id.action_fragmentB_to_fragmentD, bundle)
                } else {
                    Toast.makeText(activity, "Enter a name", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.btn_cancel -> {
                activity?.onBackPressed()
            }
        }
    }
}