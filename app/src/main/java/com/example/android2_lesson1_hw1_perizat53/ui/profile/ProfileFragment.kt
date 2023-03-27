package com.example.android2_lesson1_hw1_perizat53.ui.profile

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.android2_lesson1_hw1_perizat53.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private var mGetContent = registerForActivityResult<String, Uri>(
        ActivityResultContracts.GetContent()
    ) { uri -> Log.e("ololo",":"+ uri )
        binding.imageIcon.setImageURI(uri)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(inflater, container, false)

        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.imageIcon.setOnClickListener{
            pickImageFromGallery()
        }
    }

    private fun pickImageFromGallery() {
           mGetContent.launch("image/*")
         }
}
// I've commented old version.It also works exactly the same.
// I rewrote it because the function  startActivityForResult is deprecated

/*val intent = Intent(Intent.ACTION_PICK)
     intent.type = "image/*"
     startActivityForResult(intent, IMAGE_PICK_CODE)
        companion object {
        private val IMAGE_PICK_CODE = 1000

       override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
           if (requestCode == IMAGE_PICK_CODE && resultCode == Activity.RESULT_OK) {
               binding.imageIcon.setImageURI(data?.data)
            }
    }*/