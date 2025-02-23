package com.carvalho.valorantinfo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.carvalho.valorantinfo.adapter.AgentAdapter
import com.carvalho.valorantinfo.databinding.ActivityMainBinding
import com.carvalho.valorantinfo.ui.AgentViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: AgentViewModel by viewModels()
    private val agentAdapter = AgentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewCarousel.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.recyclerViewCarousel.adapter = agentAdapter

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerViewCarousel)

        viewModel.fetchAgents()

        lifecycleScope.launch {
            viewModel.agents.collect { agentList ->
                agentAdapter.updateAgents(agentList)
            }
        }
    }
}
