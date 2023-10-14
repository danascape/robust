package dev.dsi.robust.fridge.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.dsi.robust.databinding.RecyclerViewItemBinding
import dev.dsi.robust.fridge.Database.FridgeItems
import dev.dsi.robust.fridge.Database.FridgeViewModel

class FridgeAdapter(
    private val fridgeViewModel: FridgeViewModel
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
        holder.bind(item, fridgeViewModel)
    }

    class FridgeViewHolder(
        private val binding: RecyclerViewItemBinding,
        val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FridgeItems, fridgeViewModel: FridgeViewModel) {

            binding.productName.text = item.itemName
            binding.expiry.text = item.itemExpiry
            binding.tag.text = item.itemTag
            binding.quantity.text = item.itemQuantity.toString()
            binding.fridgeCard.background =ContextCompat.getDrawable(context, item.bg)

            binding.increment.setOnClickListener {
                item.itemQuantity += 1
                fridgeViewModel.update(item)
                binding.quantity.text = item.itemQuantity.toString()
            }

            binding.decrement.setOnClickListener {
                if (item.itemQuantity <= 0) {
                    fridgeViewModel.update(item)
                    Toast.makeText(context,"Quantity cannot be less than zero",Toast.LENGTH_SHORT).show()
                } else {
                    item.itemQuantity -= 1
                    fridgeViewModel.update(item)
                    binding.quantity.text = item.itemQuantity.toString()
                }
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

    fun removeitem(position: Int) {
        fridgeViewModel.delete(fridgeList[position])
        notifyItemRemoved(position)
    }

    fun restoreItem(fridgeItems: FridgeItems, position: Int) {
        fridgeList.add(position, fridgeItems)
        notifyItemChanged(position)
        fridgeViewModel.insert(fridgeItems)
    }


}