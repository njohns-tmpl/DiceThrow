package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DieFragment : Fragment() {

    companion object {
        const val ROLLED_KEY = "Rolled"
    }

    private lateinit var dieTextView: TextView

    private val dieViewModel: DieViewModel by lazy {
        ViewModelProvider(requireActivity())[DieViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_die, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dieTextView = view.findViewById(R.id.dieTextView)

        dieViewModel.getDieRoll().observe(viewLifecycleOwner) { roll ->
            dieTextView.text = roll.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ROLLED_KEY, dieViewModel.getDieRoll().value ?: 1)
    }
}