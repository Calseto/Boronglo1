package com.borong.data

import com.borong.R

class DataKategori {
    fun allCategory() : List<Kategori> {
        val DaftarKategori = listOf(
            Kategori(1),
            Kategori(2, R.drawable.kategori2),
            Kategori(3,R.drawable.kategori4),
            Kategori(4,R.drawable.kategori5),
            Kategori(5,R.drawable.kategori6),
            Kategori(6,R.drawable.kategori7) ,
            Kategori(7,R.drawable.kategori8),
            Kategori(8,R.drawable.kategori9),
            Kategori(9,R.drawable.kategori10),
            Kategori(10,R.drawable.kategori11)

        )
        return DaftarKategori
    }

}