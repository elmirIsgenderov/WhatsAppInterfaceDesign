package com.example.whatsappclone.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.data.entity.Message
import com.example.whatsappclone.databinding.ActivityCardBinding

class MessageAdapter(val context: Context, val messageListesi: List<Message>) :
    RecyclerView.Adapter<MessageAdapter.carddakilariTutucu>() {

    inner class carddakilariTutucu(val view: ActivityCardBinding) :
        RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): carddakilariTutucu {
        val binding = ActivityCardBinding.inflate(LayoutInflater.from(context), parent, false)
        return carddakilariTutucu(binding)
    }

    override fun getItemCount(): Int {
        return messageListesi.size
    }

    override fun onBindViewHolder(holder: carddakilariTutucu, position: Int) {
        val message = messageListesi[position]
        val holder = holder.view


        holder.txtAd.text = message.name
        holder.txtMesaj.text = message.message
        holder.txtTime.text = message.time

        holder.imgProfil.setImageResource(
            context.resources.getIdentifier(message.image, "drawable", context.packageName)
        )


    }

}