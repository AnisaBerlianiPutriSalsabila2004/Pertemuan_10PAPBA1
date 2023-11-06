package com.example.pertemuan_10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pertemuan_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var deskripsi: Array<String>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        deskripsi = resources.getStringArray(R.array.list_deskripsi)

        val adapterPahlawan = DisasterAdapter(generateDummy(deskripsi)) { pahlawan ->
            val intentoDeskripsi = Intent(this@MainActivity, Detail::class.java)
            intentoDeskripsi.putExtra("IMAGE", pahlawan.imageURL)
            intentoDeskripsi.putExtra("NAMA", pahlawan.namaPahlawan)
            intentoDeskripsi.putExtra("TANGGAL", pahlawan.tanggalLahir)
            intentoDeskripsi.putExtra("DESKRIPSI", pahlawan.deskripsiSingkat)
            startActivity(intentoDeskripsi)
        }

        with(binding){
            rvDisaster.apply {
                adapter = adapterPahlawan
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }
}

fun generateDummy(deskripsi: Array<String>): List<Pahlawan> {

    return listOf(
        Pahlawan(imageURL = R.drawable.bapaksoekarno, namaPahlawan = "I.R. Soekarno", tanggalLahir = "6 Juni 1901", deskripsiSingkat = deskripsi[1]),
        Pahlawan(imageURL = R.drawable.jenderalsudirman , namaPahlawan = "Jenderal Soedirman", tanggalLahir = " 24 Januari 1916", deskripsiSingkat =deskripsi[0]),
        Pahlawan(imageURL = R.drawable.mbakmartha, namaPahlawan = "Martha Christina Tiahahu", tanggalLahir = "4 Januari 1800 ", deskripsiSingkat = deskripsi[5] ),
        Pahlawan(imageURL = R.drawable.muhammadhatta, namaPahlawan = "Mohammad Hatta", tanggalLahir = "12 Agustus 1902", deskripsiSingkat = deskripsi[3]),
        Pahlawan(imageURL = R.drawable.pattimura, namaPahlawan = "Pattimura", tanggalLahir = "8 June 1783", deskripsiSingkat = deskripsi[2]),
        Pahlawan(imageURL = R.drawable.radenajengkartini, namaPahlawan = "R.A. Kartini", tanggalLahir = "21 April 1879", deskripsiSingkat = deskripsi[4] )

    )
}