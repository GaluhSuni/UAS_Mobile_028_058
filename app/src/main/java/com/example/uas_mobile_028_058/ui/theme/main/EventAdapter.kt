package com.example.uas_mobile_028_058.ui.theme.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.uas_mobile_028_058.databinding.ItemEventBinding
import com.example.uas_mobile_028_058.models.Event
import com.example.uas_mobile_028_058.ui.theme.detail.EventDetailActivity

class EventAdapter(private var events: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val e = events[position]

        holder.binding.title.text = e.title
        holder.binding.date.text = "${e.date} • ${e.time}"
        holder.binding.location.text = e.location
        holder.binding.status.text = e.status

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, EventDetailActivity::class.java)
            intent.putExtra("event_id", e.id)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = events.size

    fun updateData(newData: List<Event>) {
        events = newData
        notifyDataSetChanged()
    }
}