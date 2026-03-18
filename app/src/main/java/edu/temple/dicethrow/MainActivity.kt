package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportFragmentManager.findFragmentById(R.id.fragment1ContainerView) == null || supportFragmentManager.findFragmentById(R.id.fragment2ContainerView) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment1ContainerView, DieFragment.newInstance(6))
                .add(R.id.fragment2ContainerView, DieFragment.newInstance(6))
                .commit()
        }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            supportFragmentManager
                .findFragmentById(R.id.fragment1ContainerView)?.run{
                    (this as DieFragment).throwDie()
                }
                supportFragmentManager
                .findFragmentById(R.id.fragment2ContainerView)?.run{
                    (this as DieFragment).throwDie()
                }
        }
    }
}