package com.example.task_2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.task_2.MainActivity
import com.example.task_2.Orders
import com.example.task_2.R
import com.example.task_2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }
        //val local_greetings = (activity as MainActivity).greetings
        val spinner: Spinner = binding.petrolArray
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            (activity as MainActivity),
            R.array.petrol_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


        binding.addOrderButton.setOnClickListener{
            var mytext = binding.textHome.getText().toString().toInt()
            var mySpinner = binding.petrolArray.selectedItem.toString()
            fun get_price(mySpinner: String) = when(mySpinner){
                "АИ-92" -> {50.32F}
                "АИ-95" -> {60.00F}
                "CHOOH2" -> {120.99F}
                else -> {0F}
            }
            var price1 = get_price(mySpinner)
            var new_order = Orders.Order(mySpinner, mytext, price1)
            (activity as MainActivity).my_orders.add_Order(new_order)
            val toast = Toast.makeText(
                requireContext().applicationContext, "Заказ добавлен!", Toast.LENGTH_SHORT
            )
            toast.show()

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

