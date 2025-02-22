package com.carvalho.valorantinfo.adapter

import Agent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carvalho.valorantinfo.AgentDetailFragment
import com.carvalho.valorantinfo.R

class AgentAdapter : RecyclerView.Adapter<AgentAdapter.AgentViewHolder>() {
    private val agentList = mutableListOf<Agent>()

    class AgentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val agentName: TextView = view.findViewById(R.id.agent_name)
        val agentImage: ImageView = view.findViewById(R.id.agent_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.agent_card, parent, false)
        return AgentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val agent = agentList[position]

        holder.agentName.text = agent.displayName

        Glide.with(holder.itemView.context)
            .load(agent.displayIcon)
            .into(holder.agentImage)

        holder.itemView.setOnClickListener {
            val detailFragment = AgentDetailFragment.newInstance(agent)
            val activity = holder.itemView.context as AppCompatActivity

            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()

            activity.findViewById<FrameLayout>(R.id.fragment_container).visibility = View.VISIBLE
            activity.findViewById<RecyclerView>(R.id.recyclerView).visibility = View.GONE
        }

    }

    override fun getItemCount(): Int = agentList.size

    fun updateAgents(newAgents: List<Agent>) {
        agentList.clear()
        agentList.addAll(newAgents)
        notifyDataSetChanged()
    }
}