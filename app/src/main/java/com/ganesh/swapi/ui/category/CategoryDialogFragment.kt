package com.ganesh.swapi.ui.category

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.ganesh.swapi.R
import com.ganesh.swapi.databinding.CategoryDialogFragmentBinding
import com.ganesh.swapi.extn.extraBundle

/**
 * Created by ganeshkumarraja on 3/15/20.
 */
class CategoryDialogFragment : DialogFragment(), ClickEvent {
    private lateinit var binding: CategoryDialogFragmentBinding

    companion object {
        const val selectedItemKey = "category"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
            .setIcon(R.drawable.ic_launcher_background)
            .create()
        val window = builder.window
        window!!.setLayout(300, 300)
        builder.show()
        return builder
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.category_dialog_fragment,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // callback to radio buttons click event
        binding.callback = this
    }

    // send selected category name to fragment and close this dialog
    override fun onTaped(v: View) {
        val radioBtn = v as RadioButton
        val selectedText = radioBtn.text.toString()

        val intent = Intent()
        intent.extraBundle(selectedItemKey, selectedText)

        targetFragment!!.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
        dismiss()
    }
}
