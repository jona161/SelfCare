package com.example.selfcare.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.selfcare.R
import com.example.selfcare.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), View.OnClickListener
{

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var navc: NavController ?= null
    var button1: ImageButton ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        navc = Navigation.findNavController(view)
        view.findViewById<ImageButton>(R.id.imageButton)?.setOnClickListener(this)
    }

    override fun onClick(v: View?){
      button1?.visibility = View.VISIBLE
      /*if (button?.visibility == View.INVISIBLE){
          button?.visibility = View.VISIBLE
      }else{
          button?.visibility = View.INVISIBLE
      }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





