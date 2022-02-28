package dev.dsi.robust.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.dsi.robust.R
import dev.dsi.robust.databinding.FragmentAboutBinding
import dev.dsi.robust.databinding.FragmentTipsBinding


class TipsFragment : Fragment() {
    private var _binding: FragmentTipsBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTipsBinding.inflate(inflater, container, false)
        binding.toolbarDashboardFridge.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }


}