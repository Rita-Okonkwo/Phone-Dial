package com.project.phonedial


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.project.phonedial.databinding.FragmentInsertBinding

/**
 * A simple [Fragment] subclass.
 */
class InsertFragment : Fragment() {

    lateinit var binding: FragmentInsertBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_insert, container, false)
        val txt : EditText = binding.insertText

        binding.nextDial.setOnClickListener {
            val num = txt.text.toString()
            //using safe args and nav directions
            Navigation.findNavController(view!!).navigate(InsertFragmentDirections.actionInsertFragmentToDialFragment(num))
        }
        return binding.root
    }


}
