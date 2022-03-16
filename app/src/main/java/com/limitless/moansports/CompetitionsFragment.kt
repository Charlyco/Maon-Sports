package com.limitless.moansports

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.NavAction
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.limitless.moansports.data.CompetitionsItem
import com.limitless.moansports.databinding.CompetitionsFragmentBinding

class CompetitionsFragment : Fragment(), OnItemClickedListener {
    private lateinit var viewModel: CompetitionsViewModel
    private lateinit var viewModelFactory: CompetitionsViewModeFactory
    private lateinit var competitionBinding: CompetitionsFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CompetitionsAdapter
    private lateinit var application: Application
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        competitionBinding = CompetitionsFragmentBinding.inflate(inflater,
            container, false)
        recyclerView = competitionBinding.competitionRview
        application = requireActivity().application
        viewModelFactory = CompetitionsViewModeFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory)[CompetitionsViewModel::class.java]
        viewModel.saveCompetitions()
        viewModel.getCompetitions()
        viewModel.competitionsLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter = CompetitionsAdapter(it)
               displayCompetitions()
            }
        })

        return competitionBinding.root
    }

    private fun displayCompetitions() {
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter
        adapter.setClickedListener(this)
    }

    override fun onClick(view: View?, position: Int) {
        val competitionItem: CompetitionsItem = adapter.getCompetitionItemAtPosition(position)
        //viewModel.setTeamId(competitionItem.id)
        navigateToTeamsFragment(competitionItem.id, view)
    Toast.makeText(context, "Clicked on $competitionItem", Toast.LENGTH_LONG).show()
    }

    private fun navigateToTeamsFragment(id: Int, view: View?) {
        val bundle = bundleOf("teamId" to id)
        val action = CompetitionsFragmentDirections
            .actionCompetitionsFragmentToTeamsFragment(id)
            view?.findNavController()?.navigate(R.id.action_competitionsFragment_to_teamsFragment, bundle)
        }

}