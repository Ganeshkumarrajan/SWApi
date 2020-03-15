package com.ganesh.swapi.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ganesh.swapi.R
import com.ganesh.swapi.databinding.SearchListFragmentBinding
import com.ganesh.swapi.ui.category.CategoryDialogFragment
import com.ganesh.swapi.ui.category.ClickEvent

/**
 * Created by ganeshkumarraja on 3/14/20.
 */
class SearchListFragment : Fragment(), ClickEvent {
    private lateinit var binding: SearchListFragmentBinding

    companion object {
        const val requescode = 10001
        const val dialogFragmentTagName = "DialogFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_list_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.callback = this
    }

    // show the list of category name when user tab "search by" the button
    override fun onTaped(v: View) {
        fragmentManager?.let {
            val dialogFragment = CategoryDialogFragment()
            dialogFragment.setTargetFragment(this, requescode)
            dialogFragment.show(it, dialogFragmentTagName)
        }
    }

    // when user pick any one of category name from the list in the dialog
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.let {
            val action = SearchListFragmentDirections.navigateToDetails(
                it.getStringExtra(CategoryDialogFragment.selectedItemKey)
            )
            // move to detail screen with selected item
            findNavController().navigate(action)
        }
    }
}
