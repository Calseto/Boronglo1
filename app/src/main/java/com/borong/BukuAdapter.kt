package com.borong

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.borong.data.Produk
import kotlinx.android.synthetic.main.list_buku.view.*

class BukuAdapter(val ListProduk : List<Produk?>):RecyclerView.Adapter<BukuAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.list_buku,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount() = ListProduk.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Barang = ListProduk[position]
        holder.bind(Barang)
    }
    class ViewHolder(private val view:View) : RecyclerView.ViewHolder(view) {
        fun bind(Barang: Produk?) {
            val MaxNama:Int =20
            val PanjanNama:Int = Barang?.namaProduk!!.length
            if (PanjanNama > MaxNama)
            {
                val lol = Barang.namaProduk.removeRange(20,Barang.namaProduk.length)
                itemView.JudulBuku.text = lol.plus(".....")
            }
            else
            {
                itemView.JudulBuku.text= Barang.namaProduk
            }


            itemView.HargaBuku.text = "RP.${Barang.harga}"
            if(Barang.gambar==""){
                itemView.GambarProduk.setImageResource(R.drawable.noimage)
            }
            else{
                Picasso.get().load(Barang.gambar).into(itemView.GambarProduk)
            }
            view.GambarProduk.setOnClickListener {
                val action =
                    FirstFragmentDirections.actionFirstFragmentToInfoProduct(Barang.sku.toString())
                view.findNavController().navigate(action)
            }

        }

    }

}