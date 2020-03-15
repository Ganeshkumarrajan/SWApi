package com.ganesh.swapi.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ganesh.swapi.R
import com.ganesh.swapi.databinding.DetailsFragmentBinding
/**
 * Created by ganeshkumarraja on 3/15/20.
 */
class DetailsFragment : Fragment() {
    lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.details_fragment, container, false)
        return binding.root
    }
}
