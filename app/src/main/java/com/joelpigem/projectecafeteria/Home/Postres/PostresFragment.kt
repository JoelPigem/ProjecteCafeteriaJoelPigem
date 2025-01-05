package com.joelpigem.projectecafeteria.Home.Postres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.joelpigem.projectecafeteria.Home.CustomAdapter
import com.joelpigem.projectecafeteria.Home.Menjar.MenjarsViewModel
import com.joelpigem.projectecafeteria.Home.ShareViewModel
import com.joelpigem.projectecafeteria.R
import com.joelpigem.projectecafeteria.databinding.FragmentMenjarsBinding

class PostresFragment : Fragment() {

    private val sharedViewModel: ShareViewModel by activityViewModels()
    private val viewModel: PostresViewModel by viewModels()
    private lateinit var binding: FragmentMenjarsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMenjarsBinding.inflate(inflater)

        //RecyclerView
        val recyclerview = binding.recyclerview

        recyclerview.layoutManager = LinearLayoutManager(this.activity)

        viewModel.generarProductes()
        val postres = viewModel.postres

        val adapterRecycler = CustomAdapter(postres) { menuModel ->

            sharedViewModel.afegirAlMenu(menuModel)
        }

        recyclerview.adapter = adapterRecycler

        // Inflate the layout for this fragment
        return binding.root
    }

}