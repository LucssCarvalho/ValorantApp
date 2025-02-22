package com.carvalho.valorantinfo.adapter

import Ability
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carvalho.valorantinfo.R

class AbilityAdapter(private val abilities: List<Ability>) :
    RecyclerView.Adapter<AbilityAdapter.AbilityViewHolder>() {

    class AbilityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val abilityIcon: ImageView = view.findViewById(R.id.ability_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ability, parent, false)
        return AbilityViewHolder(view)
    }

    override fun onBindViewHolder(holder: AbilityViewHolder, position: Int) {
        val ability = abilities[position]
        Glide.with(holder.itemView.context)
            .load(ability.displayIcon)
            .into(holder.abilityIcon)
    }

    override fun getItemCount(): Int = abilities.size
}
