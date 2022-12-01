package com.example.task_2.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.task_2.MainActivity
import com.example.task_2.Orders
import com.example.task_2.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Отображение списка заказов
        var allOrders_text = (activity as MainActivity).my_orders.orders_info_get()
        binding.allOrders.text = "allOrders_text"
        return root
    }

    override fun onStart() {
        super.onStart()
        var allOrders_text = (activity as MainActivity).my_orders.orders_info_get()
        binding.allOrders.text = allOrders_text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}