package com.example.whatsappclone.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappclone.R
import com.example.whatsappclone.data.entity.Message
import com.example.whatsappclone.databinding.FragmentMainBinding
import com.example.whatsappclone.ui.adapter.MessageAdapter

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.mainRV.layoutManager = LinearLayoutManager(requireActivity())

        val messageListesi = ArrayList<Message>()

        val m1 = Message("Benjamin Miller", "Hi,how are you?", "12:30 PM", "picture_profil")
        val m2 = Message("Sophia Martinez", "I'll call you later.", "1:50 PM", "picture_profil_5")
        val m3 = Message("Lucas Young", "Can you send the report?", "3:15 PM", "picture_profil_1")
        val m4 = Message("Emily Johnson", "I hope you're doing well! ", "5:10 PM", "picture_profil_6")
        val m5 = Message("Noah Scott", "I miss our conversations!", "7:30 PM", "picture_profil_8")
        val m6 = Message("Henry Walker", "Hello my friend", "9:40 PM", "picture_empty")
        val m7 = Message("Isabella Brown", "Thank you so much for your help!", "Yesterday", "picture_profil_4")
        val m8 = Message("John Oliver", "Can i send you my password?", "Yesterday", "picture_profil_3")
        messageListesi.add(m1)
        messageListesi.add(m2)
        messageListesi.add(m3)
        messageListesi.add(m4)
        messageListesi.add(m5)
        messageListesi.add(m6)
        messageListesi.add(m7)
        messageListesi.add(m8)

        val adapter = MessageAdapter(requireActivity(), messageListesi)
        binding.mainRV.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.mainToolbar)

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}