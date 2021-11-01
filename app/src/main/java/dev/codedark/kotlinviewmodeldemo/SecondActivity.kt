package dev.codedark.kotlinviewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dev.codedark.kotlinviewmodeldemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras
        val n1 = extras?.getInt("FIRST_NUMBER") ?: 0
        val n2 = extras?.getInt("SECOND_NUMBER") ?: 0

        var secondActivityViewModel = ViewModelProvider(this).get(SecondActivityViewModel::class.java)

        binding.tvFirstNumber.text = n1.toString()
        binding.tvSecondNumber.text = n2.toString()

//        binding.tvThirdNumber.text = secondActivityViewModel.number3.toString()
//        binding.tvForthNumber.text = secondActivityViewModel.number4.toString()
        secondActivityViewModel.number3.observe(this, {
            binding.tvThirdNumber.text = it.toString()
        })

        secondActivityViewModel.number4.observe(this, {
            binding.tvForthNumber.text = it.toString()
        })

        binding.btnAddThirdButton.setOnClickListener {
            secondActivityViewModel.addNumber3()
        }

        binding.btnAddForthButton.setOnClickListener {
            secondActivityViewModel.addNumber4()
        }

    }
}