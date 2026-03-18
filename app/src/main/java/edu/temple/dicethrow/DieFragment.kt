package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {
    private lateinit var dieTextView: TextView
    private var currentRoll = 0
    private var dieSides = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dieSides = it.getInt(DIE_SIDE, 6)
        }
        savedInstanceState?.let {
            currentRoll = it.getInt(ROLL_KEY, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (currentRoll == 0)
            throwDie()
        else
            dieTextView.text = currentRoll.toString()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ROLL_KEY, currentRoll)
    }

    fun throwDie() {
        currentRoll = Random.nextInt(1, dieSides)
        dieTextView.text = currentRoll.toString()
    }

    companion object {
        private const val DIE_SIDE = "sidenumber"
        private const val ROLL_KEY = "current_roll"
        fun newInstance(sides: Int = 6): DieFragment {
            return DieFragment().apply {
                arguments = Bundle().apply {
                    putInt(DIE_SIDE, sides)
                }
            }
        }
    }
}