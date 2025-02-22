package com.carvalho.valorantinfo.adapter

import Agent
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carvalho.valorantinfo.R

class AgentAdapter : RecyclerView.Adapter<AgentAdapter.AgentViewHolder>() {
    private val agentList = mutableListOf<Agent>()

    class AgentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val agentName: TextView = view.findViewById(R.id.agent_name)
        val agentImage: ImageView = view.findViewById(R.id.agent_image)
        val agentBackground: ImageView = view.findViewById(R.id.agent_background)
        val rvAbilities: RecyclerView = view.findViewById(R.id.rv_ability)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.agent_card, parent, false)
        return AgentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val agent = agentList[position]

        holder.agentName.text = agent.displayName

        Glide.with(holder.itemView.context)
            .load(agent.background)
            .into(holder.agentBackground)

        val tintColor = ContextCompat.getColor(holder.itemView.context, R.color.colorDark)
        holder.agentBackground.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)

        Glide.with(holder.itemView.context)
            .load(agent.fullPortrait)
            .into(holder.agentImage)

        holder.rvAbilities.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        val abilityAdapter = AbilityAdapter(agent.abilities)
        holder.rvAbilities.adapter = abilityAdapter
    }

    override fun getItemCount(): Int = agentList.size

    fun updateAgents(newAgents: List<Agent>) {
        agentList.clear()
        agentList.addAll(newAgents.filter { it.isPlayableCharacter }.sortedBy { it.displayName })
        notifyDataSetChanged()
    }
}