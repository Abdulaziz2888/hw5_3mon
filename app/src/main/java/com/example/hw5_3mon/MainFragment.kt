package com.example.hw5_3mon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw5_3mon.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
    }

    private fun initClick() {
        binding.btnPlus.setOnClickListener {
            count++
            binding.tvResult.text = count.toString()
            if (binding.tvResult.text.toString() == "10"){
                val secondFragment = SecondFragment()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container,secondFragment).addToBackStack(null).commit()
            }
        }
        binding.btnMinus.setOnClickListener {
            count--
            binding.tvResult.text = count.toString()
        }
    }
}