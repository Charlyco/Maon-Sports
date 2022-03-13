package com.limitless.moansports

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.limitless.moansports.data.CompetitionsItem
import com.limitless.moansports.databinding.CompetitionRowBinding

class CompetitionsAdapter(private val dataset: MutableList<CompetitionsItem>):
    RecyclerView.Adapter<CompetitionsAdapter.CompetitionsViewHolder>() {

    class CompetitionsViewHolder(val binding: CompetitionRowBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(get: CompetitionsItem) {
            binding.textViewLeagueName.text = get.name
            binding.textViewCountry.text = get.area.name
            binding.textViewStartDate.text = get.currentSeason.startDate
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionsViewHolder {
        return CompetitionsViewHolder(
            CompetitionRowBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        )
    }

    override fun onBindViewHolder(holder: CompetitionsViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}