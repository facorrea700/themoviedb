package com.example.themoviedb.user.register
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.themoviedb.databinding.FragmentRegisterBinding
import com.example.themoviedb.user.User
import com.example.themoviedb.user.data.UserApplication

class RegisterFragment : Fragment() {
    lateinit var user: User
    private val viewModel: UserViewModel by activityViewModels {
        UserViewModelFactory(
            (activity?.application as UserApplication).database.userDao()
        )
    }
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.inputRegisterName.text.toString(),
            binding.inputRegisterSurname.text.toString(),
            binding.inputRegisterEmail.text.toString(),
            binding.inputRegisterPassword.text.toString(),
        )
    }
   private fun addNewItem() {
        if (isEntryValid()) {
            viewModel.addNewItem(
                binding.inputRegisterName.text.toString(),
                binding.inputRegisterSurname.text.toString(),
                binding.inputRegisterEmail.text.toString(),
                binding.inputRegisterPassword.text.toString(),
            )
           // val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
           // findNavController().navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.inputRegisterButton.setOnClickListener {
                addNewItem()
            val userName: String = binding.inputRegisterName.text.toString()
                clean()
            welcome(userName)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.
        val inputMethodManager = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }

    private fun welcome(name: String){
        Toast.makeText(context, "User  $name registered", Toast.LENGTH_SHORT).show()
    }

    private fun clean(){
        binding.inputRegisterName.setText("")
        binding.inputRegisterSurname.setText("")
        binding.inputRegisterEmail.setText("")
        binding.inputRegisterPassword.setText("")
    }
}
