package com.limitless.moansports

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.limitless.moansports.data.CompetitionsItem
import com.limitless.moansports.databinding.CompetitionsFragmentBinding

class CompetitionsFragment : Fragment() {

    companion object {
        fun newInstance() = CompetitionsFragment()
    }

    private lateinit var viewModel: CompetitionsViewModel
    private lateinit var competitionBinding: CompetitionsFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataset: MutableList<CompetitionsItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        competitionBinding = CompetitionsFragmentBinding.inflate(inflater,
            container, false)
        recyclerView = competitionBinding.competitionRview

        viewModel = ViewModelProvider(this)[CompetitionsViewModel::class.java]
        viewModel.getLatestNews()
        viewModel.competitionsLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
               displayCompetitions(it)
            }
        })

        return competitionBinding.root
    }

    private fun displayCompetitions(competitions: MutableList<CompetitionsItem>) {
        val adapter = CompetitionsAdapter(competitions)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter
    }
}