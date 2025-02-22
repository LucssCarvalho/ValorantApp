package com.carvalho.valorantinfo

import Agent
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class AgentDetailFragment : Fragment() {

    companion object {
        private const val ARG_AGENT = "agent"
        fun newInstance(agent: Agent): AgentDetailFragment {
            val fragment = AgentDetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARG_AGENT, agent)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var agent: Agent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            agent = it.getParcelable(ARG_AGENT)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_agent_detail, container, false)
        val agentImage: ImageView = view.findViewById(R.id.agent_image_detail)
        val agentName: TextView = view.findViewById(R.id.agent_name_detail)
        val agentDescription: TextView = view.findViewById(R.id.agent_description_detail)

        agent?.let {
            agentName.text = it.displayName
            agentDescription.text = it.description
            Glide.with(requireContext())
                .load(it.fullPortrait)
                .into(agentImage)
        }
        return view
    }
}
