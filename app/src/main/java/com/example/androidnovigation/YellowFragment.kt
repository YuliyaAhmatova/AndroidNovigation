package com.example.androidnovigation

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidnovigation.databinding.FragmentYellowBinding
import kotlin.getValue

class YellowFragment : Fragment() {

    private var _binding: FragmentYellowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentYellowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarYellow)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.toolbarYellow.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val args: YellowFragmentArgs by navArgs()
        val text = args.myArgYellow
        binding.yellowTV.text = text

        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.blink)
        binding.yellowTV.startAnimation(animation)
    }
}