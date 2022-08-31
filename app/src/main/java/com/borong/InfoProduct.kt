package com.borong

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.borong.data.Produk
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.info_product.*


class InfoProduct:Fragment() {
    var db = FirebaseFirestore.getInstance()
    lateinit var snapshot: Task<QuerySnapshot>
    val args : InfoProductArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.info_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ID = args.ProductDescriptionArgument
        if(ID.contains("Afk")){
            snapshot = db.collection("AFK").get()
        }
        if(ID.contains("Ae")){
            snapshot = db.collection("Alat Elektronik").get()
        }
        if(ID.contains("Apc")){
            snapshot = db.collection("APC 19").get()
        }
        if(ID.contains("Apg")){
            snapshot = db.collection("Alat Peraga").get()
        }
        if(ID.contains("atk")){
            snapshot = db.collection("ATK").get()
        }
        if(ID.contains("Bp")){
            snapshot = db.collection("Buku Pendidikan").get()
        }
        if(ID.contains("Ft")){
            snapshot = db.collection("Furniture").get()
        }
        if(ID.contains("Ms")){
            snapshot = db.collection("Mesin").get()
        }
        if(ID.contains("Mm")){
            snapshot = db.collection("Multi Media").get()
        }
        if(ID.contains("Rv")){
            snapshot = db.collection("Renovasi").get()
        }

        snapshot.addOnSuccessListener {
            var a =it.documents.map {
                it.toObject(Produk::class.java)

            }
                val Barang = a.find { it?.sku == ID }
                if (Barang!= null){
                    TitleProduct.text = Barang.namaProduk
                    HargaProductDescription.text = "Rp.${Barang.harga}"
                    DescriptionProduct.text= Barang.deskripsi
                    if(Barang.gambar==""){
                        GambarProductDeskripsi.setImageDrawable(getResources().getDrawable(R.drawable.noimage))
                    }
                    else{
                        Picasso.get().load(Barang.gambar).into(GambarProductDeskripsi)
                    }

                }
                 else{
                    TitleProduct.text = "Barang Tidak Tersedia"

                }
            var linkHttp: String? = Barang?.link.toString()
            if (Barang?.link?.get(0) == ' ') {
                linkHttp = Barang.link.toString().replace(" h", "h")
            }
            LinkButton.setOnClickListener{

                if(Barang?.link !=null) {
                    val browserIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse(linkHttp))
                    startActivity(browserIntent)
                }

            }



        }
    }
}