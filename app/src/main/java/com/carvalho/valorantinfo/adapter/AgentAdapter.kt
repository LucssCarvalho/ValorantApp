package com.carvalho.valorantinfo.adapter

import Agent
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carvalho.valorantinfo.R
import com.carvalho.valorantinfo.databinding.AgentCardBinding

class AgentAdapter : RecyclerView.Adapter<AgentAdapter.AgentViewHolder>() {
    private val agentList = mutableListOf<Agent>()

    class AgentViewHolder(val binding: AgentCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val binding = AgentCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AgentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val agent = agentList[position]
        with(holder.binding) {
            agentName.text = agent.displayName

            Glide.with(root.context)
                .load(agent.background)
                .into(agentBackground)

            val tintColor = ContextCompat.getColor(root.context, R.color.colorDark)
            agentBackground.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)

            Glide.with(root.context)
                .load(agent.fullPortrait)
                .into(agentImage)

            rvAbility.layoutManager =
                LinearLayoutManager(root.context, LinearLayoutManager.HORIZONTAL, false)
            val abilityAdapter = AbilityAdapter(agent.abilities)
            rvAbility.adapter = abilityAdapter
        }
    }

    override fun getItemCount(): Int = agentList.size

    fun updateAgents(newAgents: List<Agent>) {
        agentList.clear()
        agentList.addAll(newAgents.filter { it.isPlayableCharacter }.sortedBy { it.displayName })
        notifyDataSetChanged()
    }
}
