package dev.dsi.robust.fridge.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import dev.dsi.robust.databinding.RecyclerViewItemBinding
import dev.dsi.robust.fridge.Database.FridgeItems

class FridgeAdapter(
    var list: List<FridgeItems>,
    val fridgeItemClickInterface:FridgeItemClickInterface
):RecyclerView.Adapter<FridgeAdapter.FridgeViewHolder>() {


    inner class FridgeViewHolder(val binding:RecyclerViewItemBinding,val context: Context):RecyclerView.ViewHolder(binding.root) {




    }

    interface FridgeItemClickInterface {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FridgeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemBinding.inflate(layoutInflater,parent ,false)
        return FridgeViewHolder(binding,parent.context)
    }

    override fun onBindViewHolder(holder: FridgeViewHolder, position: Int) {
       holder.binding.productName.text=list.get(position).itemName
        holder.binding.quantity.text=list.get(position).itemQuantity.toString()
        holder.binding.expiry.text=list.get(position).itemExpiry.toString()
        holder.binding.tag.text=list.get(position).itemTag.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }


}