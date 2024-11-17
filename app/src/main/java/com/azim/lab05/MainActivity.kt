package com.azim.lab05

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.azim.lab05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ActivityMain => Reverse of our Activity name (MainActivity)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding     = ActivityMainBinding.inflate(layoutInflater)
        val view    = binding.root
        setContentView(view)

        binding.btnOrder.setOnClickListener {
            var pizzaSizePrice  = 0.0   // type Double
            var toppingSize     = 0.0   // type Double

            // Only 1 option can be selected
            when {
                // isChecked is the property to see if an item is selected
                binding.rdBtnSmall.isChecked    -> pizzaSizePrice = 5.00
                binding.rdBtnMedium.isChecked   -> pizzaSizePrice = 7.00
                binding.rdBtnLarge.isChecked    -> pizzaSizePrice = 10.00
            }

            // Multiple choices can be selected
            if (binding.boxOlives.isChecked) {
                toppingSize += 2
            }
            if (binding.boxOnions.isChecked) {
                toppingSize += 1
            }
            if (binding.boxTomatoes.isChecked) {
                toppingSize += 3
            }

            binding.txtResult.text = "Total Price is : RM ${pizzaSizePrice + toppingSize}"
        }
    }
}