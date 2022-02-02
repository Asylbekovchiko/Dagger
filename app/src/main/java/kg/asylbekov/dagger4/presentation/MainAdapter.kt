package kg.asylbekov.dagger4.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.asylbekov.dagger4.databinding.ChatItemBinding
import kg.asylbekov.domain.models.CoinResponse
import kg.asylbekov.domain.models.Currency

class MainAdapter() :
    RecyclerView.Adapter<MainAdapter.SmsVH>() {
    var list = emptyList<Currency>()

    @SuppressLint("NotifyDataSetChanged")
    fun setListSMS(list: List<Currency>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class SmsVH(val binding: ChatItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun onBind(a: Currency) {
            binding.tvCode.text = "Code:" + a.code
            binding.tvDescription.text = "Description:" + a.description
            binding.tvRate.text = "Rate:" + a.rate
            binding.tvSymbol.text = "Symbol:" + a.symbol
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmsVH {
        val binding =
            ChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SmsVH(binding)
    }

    override fun onBindViewHolder(holder: SmsVH, position: Int) {
        holder.onBind(list[position])


    }

    override fun getItemCount(): Int {
        return list.size
    }


}