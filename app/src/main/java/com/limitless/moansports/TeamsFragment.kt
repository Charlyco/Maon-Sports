package com.limitless.moansports

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.NavArgument
import androidx.navigation.fragment.navArgs
import com.limitless.moansports.databinding.FragmentTeamsBinding

class TeamsFragment : Fragment() {
    private var param1: Int? = null
    private var competitionId: Int = 0
    private lateinit var teamsBinding: FragmentTeamsBinding
    private lateinit var viewModelFactory: CompetitionsViewModeFactory
    private lateinit var viewModel: CompetitionsViewModel
    private lateinit var application: Application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            if (it != null) {
                competitionId = it.getInt("teamId")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        teamsBinding = FragmentTeamsBinding.inflate(inflater, container, false)
        application = requireActivity().application
        viewModelFactory = CompetitionsViewModeFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory)[CompetitionsViewModel::class.java]
        viewModel.getTeams(competitionId)
//        viewModel.teamId.observe(viewLifecycleOwner) {
//            if (it != null){
//                Log.i("ID:",it.toString())
//                competitionId = it
//            }
        //}
        viewModel.teamsLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                teamsBinding.teams.text = it.toString()
            }
        }
        return teamsBinding.root
    }

}