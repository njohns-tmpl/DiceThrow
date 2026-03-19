package edu.temple.dicethrow

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {
    private val dieRoll = MutableLiveData<Int>()
    var dieSides: Int = 6

    fun rollDie(dieSides: Int = this.dieSides) {
        dieRoll.value = (Random.nextInt(1, dieSides )+1)

    }
    fun getDieRoll(): LiveData<Int> {
        return dieRoll
    }

    fun setSides(sides: Int){
        dieSides = sides
    }

}