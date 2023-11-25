package com.example.githubsearchapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.githubsearchapp.R
import com.example.githubsearchapp.databinding.FragmentFirstBinding
import com.example.githubsearchapp.viewmodel.MainViewModel
import com.example.githubsearchapp.viewmodel.common.kodeinViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val viewModel: MainViewModel by kodeinViewModel()

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            getSampleData()
        }
    }

    private fun getSampleData() {

        viewModel.getSampleData().observe(viewLifecycleOwner) {
            Log.e("Tag", it.toString())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}