package cn.gavinliu.android.lib.linebreak.demo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.gavinliu.android.lib.linebreak.demo.databinding.ActivityMainBinding
import cn.gavinliu.android.lib.linebreak.ktx.lineBreak
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = ResultAdapter()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.rvResult.layoutManager = FlexboxLayoutManager(this).apply {
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
            justifyContent = JustifyContent.FLEX_START
        }
        binding.rvResult.adapter = adapter

        binding.btn.setOnClickListener {
            adapter.data = binding.textInputEdit.text.toString().lineBreak()
            adapter.notifyDataSetChanged()
        }

        binding.textSizeAdd.setOnClickListener {
            adapter.textSize += 1
            adapter.notifyDataSetChanged()
        }

        binding.textSizeCut.setOnClickListener {
            adapter.textSize -= 1
            adapter.notifyDataSetChanged()
        }
    }

}