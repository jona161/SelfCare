package com.example.selfcare.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.selfcare.R
import com.example.selfcare.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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

        view.findViewById<Button>(R.id.buttonFrontHead)?.setOnClickListener(this)
        view.findViewById<Button>(R.id.buttonFrontTorso1)?.setOnClickListener(this)
        view.findViewById<Button>(R.id.buttonFrontTorso2)?.setOnClickListener(this)
        view.findViewById<Button>(R.id.buttonFrontArmRight1)?.setOnClickListener(this)
        view.findViewById<Button>(R.id.buttonFrontArmRight2)?.setOnClickListener(this)
        view.findViewById<Button>(R.id.buttonFrontArmLeft1)?.setOnClickListener(this)
        view.findViewById<Button>(R.id.buttonFrontArmLeft2)?.setOnClickListener(this)
        view.findViewById<Button>(R.id.buttonFrontLegRight)?.setOnClickListener(this)
        view.findViewById<Button>(R.id.buttonFrontLegLeft)?.setOnClickListener(this)
    }

    fun changeVisibility(view: ImageView?){
        if (view?.visibility == View.VISIBLE) {
            view?.visibility = View.INVISIBLE
        }else{
            view?.visibility = View.VISIBLE
        }
    }


    override fun onClick(v: View?){

      var viewFrontHead = view?.findViewById<ImageView>(R.id.imageFrontHead)
      var viewFrontTorso = view?.findViewById<ImageView>(R.id.imageFrontTorso)
      var viewFrontArmRight = view?.findViewById<ImageView>(R.id.imageFrontArmRight)
      var viewFrontArmLeft = view?.findViewById<ImageView>(R.id.imageFrontArmLeft)
      var viewFrontLegRight = view?.findViewById<ImageView>(R.id.imageFrontLegRight)
      var viewFrontLegLeft = view?.findViewById<ImageView>(R.id.imageFrontLegLeft)

      when (v?.id){
          2131231255 -> changeVisibility(viewFrontHead)
          2131231256 -> changeVisibility(viewFrontTorso)
          2131231257 -> changeVisibility(viewFrontTorso)
          2131231258 -> changeVisibility(viewFrontArmLeft)
          2131231259 -> changeVisibility(viewFrontArmLeft)
          2131231260 -> changeVisibility(viewFrontArmRight)
          2131231261 -> changeVisibility(viewFrontArmRight)
          2131231262 -> changeVisibility(viewFrontLegLeft)
          2131231263 -> changeVisibility(viewFrontLegRight)
      }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





