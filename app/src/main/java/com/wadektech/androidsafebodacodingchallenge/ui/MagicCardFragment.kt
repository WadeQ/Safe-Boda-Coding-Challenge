package com.wadektech.androidsafebodacodingchallenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.SearchViewBindingAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.wadektech.androidsafebodacodingchallenge.R
import com.wadektech.androidsafebodacodingchallenge.adapter.MagicCardAdapter
import com.wadektech.androidsafebodacodingchallenge.databinding.FragmentMagicCardBinding
import com.wadektech.androidsafebodacodingchallenge.databinding.FragmentMagicCardDetailsBinding
import com.wadektech.androidsafebodacodingchallenge.utils.toast
import com.wadektech.androidsafebodacodingchallenge.viewmodels.MagicCardViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [MagicCardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MagicCardFragment : Fragment() {

    private val magicCardViewModel : MagicCardViewModel by lazy {
        ViewModelProvider(this).get(MagicCardViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentMagicCardBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewmodel = magicCardViewModel

        binding.rvMagic.adapter = MagicCardAdapter(MagicCardAdapter.OnSingleCardItemClicked{
            magicCardViewModel.displayMagicCardDetails(it)
        })

        magicCardViewModel.navigateToDetailsFragment.observe(viewLifecycleOwner, Observer {
            if (it!=null){
                this.findNavController().navigate(MagicCardFragmentDirections.actionMagicCardFragmentToMagicCardDetailsFragment(it))
                magicCardViewModel.displayMagicCardDetailsCompleted()
            }
        })

        return binding.root
    }
}