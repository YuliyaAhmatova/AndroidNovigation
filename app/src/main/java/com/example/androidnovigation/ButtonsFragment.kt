package com.example.androidnovigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.androidnovigation.databinding.FragmentButtonsBinding

@Suppress("OVERRIDE_DEPRECATION")
class ButtonsFragment : Fragment() {

    private var _binding: FragmentButtonsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentButtonsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarButtons)
        binding.redBTN.setOnClickListener {
//            view.findNavController().navigate(R.id.action_buttonsFragment_to_redFragment)
            val name = binding.redBTN.text.toString()
            val action = ButtonsFragmentDirections.actionButtonsFragmentToRedFragment(name)
            val extras = FragmentNavigatorExtras(
                binding.redBTN to "redBTN"
            )
            findNavController().navigate(action, extras)
        }
        binding.yellowBTN.setOnClickListener {
            val name = binding.yellowBTN.text.toString()
            val action = ButtonsFragmentDirections.actionButtonsFragmentToYellowFragment(name)
            val extras = FragmentNavigatorExtras(
                binding.yellowBTN to "yellowBTN"
            )
            findNavController().navigate(action, extras)
        }
        binding.greenBTN.setOnClickListener {
            val name = binding.greenBTN.text.toString()
            val action = ButtonsFragmentDirections.actionButtonsFragmentToGreenFragment(name)
            val extras = FragmentNavigatorExtras(
                binding.greenBTN to "greenBTN"
            )
            findNavController().navigate(action, extras)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_buttons, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitButtons -> {
                activity?.finishAffinity()
                Toast.makeText(requireContext(), "Программа завершена", Toast.LENGTH_LONG).show()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}