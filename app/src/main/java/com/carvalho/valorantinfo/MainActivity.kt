package com.carvalho.valorantinfo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carvalho.valorantinfo.adapter.AgentAdapter
import com.carvalho.valorantinfo.ui.AgentViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: AgentViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private val agentAdapter = AgentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = agentAdapter

        viewModel.fetchAgents()

        lifecycleScope.launch {
            viewModel.agents.collect { agentList ->
                agentAdapter.updateAgents(agentList)
            }
        }
    }
}
