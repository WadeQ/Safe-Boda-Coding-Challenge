package com.wadektech.androidsafebodacodingchallenge.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.wadektech.androidsafebodacodingchallenge.R
import com.wadektech.androidsafebodacodingchallenge.databinding.FragmentMagicCardDetailsBinding
import com.wadektech.androidsafebodacodingchallenge.utils.MagicCardViewModelFactory
import com.wadektech.androidsafebodacodingchallenge.viewmodels.CardDetailViewModel


class MagicCardDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMagicCardDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_magic_card_details, container, false)
        binding.lifecycleOwner = this

        val application = requireNotNull(activity).application
        val magicCardDetailsFragmentArgs = MagicCardDetailsFragmentArgs.fromBundle(requireArguments()).clickedCardItem
        val factory = MagicCardViewModelFactory(application, magicCardDetailsFragmentArgs)
        binding.details = ViewModelProvider(this,factory).get(CardDetailViewModel::class.java)

        return binding.root

    }
}