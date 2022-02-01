package kg.asylbekov.dagger4.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.asylbekov.dagger4.databinding.ChatItemBinding
import kg.asylbekov.domain.models.CoinResponse

class MainAdapter() :
    RecyclerView.Adapter<MainAdapter.SmsVH>() {
    var list = emptyList<CoinResponse>()

    @SuppressLint("NotifyDataSetChanged")
    fun setListSMS(list: List<CoinResponse>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class SmsVH(val binding: ChatItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun onBind(a: CoinResponse) {
            binding.tvMessage.text = a.bpi.eUR.code
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