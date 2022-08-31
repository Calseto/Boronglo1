package com.borong

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.borong.data.Kategori
import kotlinx.android.synthetic.main.list_kategori.view.*

class KategoriAdapter(val ListKategori: List<Kategori>):RecyclerView.Adapter<KategoriAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.list_kategori,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = ListKategori.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Kategori = ListKategori[position]
        holder.bind(Kategori)
    }
    class ViewHolder(private val view:View) : RecyclerView.ViewHolder(view) {
        fun bind(Kategori: Kategori) {
            itemView.KategoriButton.setImageResource (Kategori.GambarKategori)
            view.KategoriButton.setOnClickListener{
                val action =
                    SecondFragmentDirections.actionSecondFragmentToFirstFragment(Kategori.IDKategori)
                view.findNavController().navigate(action)

            }
        }

    }

}