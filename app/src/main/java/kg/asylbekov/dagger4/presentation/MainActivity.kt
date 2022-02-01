package kg.asylbekov.dagger4.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kg.asylbekov.dagger4.R
import kg.asylbekov.dagger4.app.App
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var vm: MainViewModel
    lateinit var adapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        (applicationContext as App).appComponent.inject(this)
        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

        adapter = MainAdapter()
//        findViewById<RecyclerView>(R.id.text).adapter = adapter

        vm._ld.observe(this, Observer {
//            adapter.setListSMS(it)
            findViewById<TextView>(R.id.text).text = it.bpi.eUR.description

        })


        findViewById<Button>(R.id.ko).setOnClickListener {

            lifecycleScope.launch {
                vm.getData()
            }
        }
    }
}