package dev.dsi.robust.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dev.dsi.robust.R
import dev.dsi.robust.databinding.FragmentAddItemBinding
import dev.dsi.robust.fridge.Database.FridgeItems
import dev.dsi.robust.fridge.Database.FridgeViewModel
import dev.dsi.robust.utils.Constants
import dev.dsi.robust.utils.Snacker
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddItemFragment : Fragment() {

    private lateinit var fridgeViewmodel: FridgeViewModel
    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    var cal = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }

        binding.calendarCard.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        binding.fabCheck.setOnClickListener {
            fridgeViewmodel = ViewModelProvider(this)[FridgeViewModel::class.java]

            if (binding.itemNameEditText.text.toString() == "") {
                Snacker(it, "Enter your item name").error()
            } else if (binding.itemCountEditText.text.toString() == "") {
                Snacker(it, "Enter the quantity you want to store").error()
            } else if (binding.calendarText.text.toString() == "") {
                Snacker(it, "Select expiry date").error()
            } else if (binding.itemCountEditText.text.toString() == "") {
                Snacker(it, "Enter the quantity you want to store").error()
            } else if (binding.itemTag.selectedItem.toString() == "") {
                Snacker(it, "Please select a tag").error()
            } else {
                val fridge = FridgeItems(
                    itemName = binding.itemNameEditText.text.toString(),
                    itemExpiry = binding.calendarText.text.toString(),
                    itemQuantity = binding.itemCountEditText.text.toString().toLong(),
                    itemTag = binding.itemTag.selectedItem.toString(),
                    bg = Constants.getRandomCardColor()
                )
                fridge.id = System.currentTimeMillis().toInt()
                fridgeViewmodel.insert(fridge)

                findNavController().navigate(R.id.action_addItemFragment_to_fridgeFragment)
            }
        }


        return binding.root
    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.calendarText.text = sdf.format(cal.time)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}