package dev.dsi.robust.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dev.dsi.robust.R
import dev.dsi.robust.databinding.FragmentFridgeBinding
import dev.dsi.robust.fridge.Adapter.FridgeAdapter
import dev.dsi.robust.fridge.Database.FridgeItems
import dev.dsi.robust.fridge.Database.FridgeViewModel


class FridgeFragment : Fragment() {
    private lateinit var fridgeViewModel: FridgeViewModel
    lateinit var fridgeAdapter: FridgeAdapter
    private var _binding:FragmentFridgeBinding? = null
    private val binding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFridgeBinding.inflate(inflater, container, false)

        fridgeViewModel = ViewModelProvider(this)[FridgeViewModel::class.java]
        fridgeAdapter = FridgeAdapter(fridgeViewModel, binding.rv.rootView, activity)
        binding.rv.adapter = fridgeAdapter
        binding.rv.layoutManager = LinearLayoutManager(context)

        fridgeViewModel.allLists.observe(viewLifecycleOwner, Observer { list ->
            if (list.isEmpty()) {
                binding.anim.visibility = View.VISIBLE
            } else {
                binding.anim.visibility = View.GONE
            }
            fridgeAdapter.submitList(list)
            fridgeAdapter.fridgeList = list as ArrayList<FridgeItems>
        })

        binding.fabAddItem.setOnClickListener{
            findNavController().navigate(R.id.action_fridgeFragment_to_addItemFragment)
        }
        return binding.root
    }

}