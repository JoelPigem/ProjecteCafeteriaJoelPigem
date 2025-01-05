package com.joelpigem.projectecafeteria.Home.Pagament

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.joelpigem.projectecafeteria.Home.CustomAdapter
import com.joelpigem.projectecafeteria.Home.ShareViewModel
import com.joelpigem.projectecafeteria.databinding.FragmentPagamentBinding


class PagamentFragment : Fragment() {

    private val sharedViewModel: ShareViewModel by activityViewModels()
    private val viewModel: PagamentsViewModel by viewModels()
    private lateinit var binding: FragmentPagamentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagamentBinding.inflate(inflater)

        var preu = 0

        sharedViewModel.preuTotalMenjar.observe(viewLifecycleOwner) { menjar ->
            binding.textViewMenjarPreu.text = "${sharedViewModel.preuTotalMenjar.value}€"
        }
        sharedViewModel.preuTotalBeguda.observe(viewLifecycleOwner) { beguda ->
            binding.textViewBegudaPreu.text = "${sharedViewModel.preuTotalBeguda.value}€"
        }
        sharedViewModel.preuTotalPostres.observe(viewLifecycleOwner) { postres ->
            binding.textViewPostresPreu.text = "${sharedViewModel.preuTotalPostres.value}€"
        }
        sharedViewModel.preuTotal.observe(viewLifecycleOwner) { preuTotal ->
            binding.textViewTotalPreu.text = "${sharedViewModel.preuTotal.value}€"
            preu = preuTotal

        }

        binding.buttonComprar.setOnClickListener {
            if (preu == 0) {
                Toast.makeText(context, "No tens productes per comprar!", Toast.LENGTH_SHORT).show()
            } else {
                sharedViewModel.comprar()
                Toast.makeText(context, "Products comprats.", Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }

}