 package com.joelpigem.projectecafeteria.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.joelpigem.projectecafeteria.Home.Postres.PostresViewModel
import com.joelpigem.projectecafeteria.R
import com.joelpigem.projectecafeteria.databinding.FragmentPreuTotalBinding

 class PreuTotalFragment : Fragment() {
     private val sharedViewModel: ShareViewModel by activityViewModels()
     private lateinit var binding: FragmentPreuTotalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPreuTotalBinding.inflate(inflater)

        sharedViewModel.preuTotal.observe(viewLifecycleOwner) { preuTotal ->
            binding.textPreuTotal.text = "Total: $preuTotal €"
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}