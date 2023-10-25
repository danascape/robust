package dev.dsi.robust.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dev.dsi.robust.R
import dev.dsi.robust.databinding.FragmentFridgeBinding
import dev.dsi.robust.fridge.Adapter.FridgeAdapter
import dev.dsi.robust.fridge.Database.FridgeItems
import dev.dsi.robust.fridge.Database.FridgeViewModel
import dev.dsi.robust.utils.SwipeToDeleteCallback

class FridgeFragment : Fragment() {

    private lateinit var fridgeViewModel: FridgeViewModel
    lateinit var fridgeAdapter: FridgeAdapter

    private var _binding: FragmentFridgeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFridgeBinding.inflate(inflater, container, false)

        fridgeViewModel = ViewModelProvider(this)[FridgeViewModel::class.java]

        fridgeAdapter = FridgeAdapter(fridgeViewModel)

        binding.rv.apply {
            adapter = fridgeAdapter
            layoutManager = LinearLayoutManager(context)
        }

        enableSwipeToDeleteAndUndo(fridgeAdapter)

        fridgeViewModel.allLists.observe(viewLifecycleOwner) { list ->

            if (list.isEmpty()) {
                binding.anim.visibility = View.VISIBLE
            } else {
                binding.anim.visibility = View.GONE
            }

            fridgeAdapter.submitList(list)
            fridgeAdapter.fridgeList = list as ArrayList<FridgeItems>
        }

        binding.fabAddItem.setOnClickListener {
            findNavController().navigate(R.id.action_fridgeFragment_to_addItemFragment)
        }

        return binding.root
    }

    private fun enableSwipeToDeleteAndUndo(fridgeAdapter: FridgeAdapter) {

        val swipeToDeleteCallback = object : SwipeToDeleteCallback(context) {

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {

                val position = viewHolder.adapterPosition
                fridgeAdapter.removeitem(position)

                val item = fridgeAdapter.getList()[position]

                AlertDialog.Builder(requireContext())
                    .setTitle("Delete")
                    .setMessage("Are you sure you want to delete?")
                    .setPositiveButton("Yes") { _, dialogInterface ->
                        Snackbar
                            .make(
                                binding.coordLayout,
                                "Item is removed from the list.",
                                Snackbar.LENGTH_SHORT
                            )
                            .show()
                    }
                    .setNegativeButton("No") { _, dialogInterface ->
                        fridgeAdapter.restoreItem(item, position)
                    }
                    .setCancelable(false)
                    .show()
            }
        }

        val itemTouchhelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchhelper.attachToRecyclerView(binding.rv)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}