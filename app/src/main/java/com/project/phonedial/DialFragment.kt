package com.project.phonedial


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.project.phonedial.databinding.FragmentDialBinding

/**
 * A simple [Fragment] subclass.
 */
class DialFragment : Fragment() {

    lateinit var binding: FragmentDialBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dial, container, false)

        val args = DialFragmentArgs.fromBundle(arguments)
        binding.numText.text = args.phoneNumber

        binding.dialBtn.setOnClickListener {
            //using explicit intent for phone dial
            val phoneNum: String = binding.numText.text.toString()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum))
            startActivity(intent)
        }
        return binding.root
    }


}
