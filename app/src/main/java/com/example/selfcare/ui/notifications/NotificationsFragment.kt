package com.example.selfcare.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.selfcare.R
import com.example.selfcare.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var navc: NavController?= null
    var button2: ImageButton ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        navc = Navigation.findNavController(view)
        view.findViewById<ImageButton>(R.id.imageButton2)?.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        //v?.visibility = View.GONE
        System.out.println("click")
        if (v?.visibility == View.INVISIBLE){
            v?.visibility = View.VISIBLE
        }else{
            v?.visibility = View.INVISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}