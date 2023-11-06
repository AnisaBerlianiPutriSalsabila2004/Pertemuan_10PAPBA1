package com.example.pertemuan_10

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan_10.databinding.ItemPahlawanBinding
import java.lang.System.load

class DisasterAdapter(private val listPahlawan: List<Pahlawan>
                      ,private val onClickPahlawan: onClickPahlawan) :
    RecyclerView.Adapter<DisasterAdapter.ItemPahwalanViewHolder>()
{
    inner class ItemPahwalanViewHolder(
        private val binding: ItemPahlawanBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Pahlawan) {

            with(binding) {
                gambarUrl.setImageResource(data.imageURL)
                namaMobilTxt.text = data.namaPahlawan
                hargaMobilTxt.text = data.tanggalLahir
                itemView.setOnClickListener {
                    onClickPahlawan(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPahwalanViewHolder {
        val binding =
            ItemPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemPahwalanViewHolder(binding)
    }
    override fun getItemCount(): Int = listPahlawan.size
    override fun onBindViewHolder(holder: ItemPahwalanViewHolder, position: Int) {
        holder.bind(listPahlawan[position])
    }
}


typealias onClickPahlawan = (Pahlawan) -> Unit