package dev.dsi.robust.fridge.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.dsi.robust.databinding.RecyclerViewItemBinding
import dev.dsi.robust.fridge.Database.FridgeItems
import dev.dsi.robust.fridge.Database.FridgeViewModel

class FridgeAdapter(
    val fridgeViewModel: FridgeViewModel,
    val parentView: View,
    val activity: FragmentActivity?,
) :
    ListAdapter<FridgeItems, FridgeAdapter.FridgeViewHolder>(
        ListDiffCallbacks()
    ) {

    var fridgeList = ArrayList<FridgeItems>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FridgeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemBinding.inflate(layoutInflater, parent, false)
        return FridgeViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: FridgeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, fridgeViewModel, parentView)
    }

    class FridgeViewHolder(val binding: RecyclerViewItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FridgeItems, fridgeViewModel: FridgeViewModel, parentView: View) {

            binding.productName.text = item.itemName.toString()
            binding.expiry.text = item.itemExpiry.toString()
            binding.tag.text = item.itemTag.toString()
            binding.quantity.text = item.itemQuantity.toString()

            binding.increment.setOnClickListener {
                item.itemQuantity += 1
                fridgeViewModel.update(item)
                binding.quantity.text = item?.itemQuantity.toString()
            }

            binding.decrement.setOnClickListener {
                item.itemQuantity -= 1
                fridgeViewModel.update(item)
                binding.quantity.text = item.itemQuantity.toString()
            }
        }

    }

    class ListDiffCallbacks : DiffUtil.ItemCallback<FridgeItems>() {
        override fun areItemsTheSame(oldItem: FridgeItems, newItem: FridgeItems): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: FridgeItems, newItem: FridgeItems): Boolean {
            return oldItem == newItem
        }

    }

    fun getList() = fridgeList


}