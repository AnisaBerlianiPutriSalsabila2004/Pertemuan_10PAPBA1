package com.example.pertemuan_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pertemuan_10.databinding.ActivityDetailBinding

class Detail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var image_url = intent.getIntExtra("IMAGE", 0)
        var nama = intent.getStringExtra("NAMA")
        var tanggal = intent.getStringExtra("TANGGAL")
        var deskripsi_singkat = intent.getStringExtra("DESKRIPSI")

        with(binding){
            namaPahlawan.text = nama
            tanggalLahir.text = tanggal
            deskripsi.text = deskripsi_singkat
            gambarDetail.setImageResource(image_url)
        }
    }
}