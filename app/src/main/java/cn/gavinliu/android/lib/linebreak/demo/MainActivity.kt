package cn.gavinliu.android.lib.linebreak.demo

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import cn.gavinliu.android.lib.linebreak.LineBreaker
import cn.gavinliu.android.lib.linebreak.demo.databinding.ActivityMainBinding
import cn.gavinliu.android.lib.linebreak.ktx.lineBreak
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.tvText.text.toString().lineBreak()

        val text = "Emojis joined by ZWJs should not be broken: 👨🏻‍💻.「你看過《三國演義》嗎？」他問我。"
        LineBreaker.lineBreak(text).forEach { Log.d("XX", it) }

        binding.rvResult.adapter = ResultAdapter(LineBreaker.lineBreak(text))
    }

}