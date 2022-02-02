package kg.asylbekov.dagger4.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kg.asylbekov.dagger4.R
import kg.asylbekov.dagger4.app.App
import kg.asylbekov.domain.models.Currency
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var vm: MainViewModel
    lateinit var adapter: MainAdapter

    val list = ArrayList<Currency>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)
        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

        adapter = MainAdapter()
        findViewById<RecyclerView>(R.id.recyclerView2).adapter = adapter

        lifecycleScope.launch {
            vm.getData()
        }

        vm._ld.observe(this, Observer {
            val eur = Currency(it.bpi.eUR.code, it.bpi.eUR.description, it.bpi.eUR.rate,it.bpi.eUR.rateFloat,it.bpi.eUR.symbol)
            val gbr = Currency(it.bpi.gBP.code, it.bpi.gBP.description, it.bpi.gBP.rate,it.bpi.gBP.rateFloat,it.bpi.gBP.symbol)
            val usd = Currency(it.bpi.uSD.code, it.bpi.uSD.description, it.bpi.uSD.rate,it.bpi.uSD.rateFloat,it.bpi.uSD.symbol)
            list.add(eur)
            list.add(gbr)
            list.add(usd)

            adapter.setListSMS(list)
            Log.e("TAG","$list")
        })
    }
}