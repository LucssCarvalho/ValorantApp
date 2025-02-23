package com.carvalho.valorantinfo.adapter

import Ability
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carvalho.valorantinfo.databinding.ItemAbilityBinding

class AbilityAdapter(private val abilities: List<Ability>) :
    RecyclerView.Adapter<AbilityAdapter.AbilityViewHolder>() {

    class AbilityViewHolder(val binding: ItemAbilityBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityViewHolder {
        val binding = ItemAbilityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AbilityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AbilityViewHolder, position: Int) {
        val ability = abilities[position]
        Glide.with(holder.binding.root.context)
            .load(ability.displayIcon)
            .into(holder.binding.abilityIcon)
    }

    override fun getItemCount(): Int = abilities.size
}
