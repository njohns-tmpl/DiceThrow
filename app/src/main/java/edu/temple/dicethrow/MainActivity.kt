package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val dieViewModel = ViewModelProvider(this).get(DieViewModel::class.java)
       dieViewModel.setSides(6)

        if(supportFragmentManager.findFragmentById(R.id.fragment1ContainerView) == null || supportFragmentManager.findFragmentById(R.id.fragment2ContainerView) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment1ContainerView, DieFragment())
                .commit()
        }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            dieViewModel.rollDie()
        }
    }
}