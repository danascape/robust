package dev.dsi.robust.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.dsi.robust.R
import dev.dsi.robust.databinding.FragmentFridgeBinding
import dev.dsi.robust.fridge.Adapter.FridgeAdapter


class FridgeFragment : Fragment() {

    lateinit var fridgeAdapter: FridgeAdapter
    private var _binding:FragmentFridgeBinding? = null
    private val binding
    get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fridge, container, false)
    }

}