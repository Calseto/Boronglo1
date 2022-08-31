package com.borong

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.borong.data.Produk
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.fragment_first.*

/**
     * A simple [Fragment] subclass as the default destination in the navigation.
     */
    class FirstFragment : Fragment() {
    val args : FirstFragmentArgs by navArgs()
    lateinit var all: List<Produk>
    lateinit var snapshot: Task<QuerySnapshot>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var db = FirebaseFirestore.getInstance()
        val IDKat= args.PilihanKategori
        if(IDKat==1){
            snapshot = db.collection("AFK").get()
        }
        if(IDKat==2){
            snapshot = db.collection("Alat Elektronik").get()
        }
        if(IDKat==3){
            snapshot = db.collection("APC 19").get()
        }
        if(IDKat==4){
            snapshot = db.collection("Alat Peraga").get()
        }
        if(IDKat==5){
            snapshot = db.collection("ATK").get()
        }
        if(IDKat==6){
            snapshot = db.collection("Buku Pendidikan").get()
        }
        if(IDKat==7){
            snapshot = db.collection("Furniture").get()
        }
        if(IDKat==8){
            snapshot = db.collection("Mesin").get()
        }
        if(IDKat==9){
            snapshot = db.collection("Multi Media").get()
        }
        if(IDKat==10){
            snapshot = db.collection("Renovasi").get()
        }
        snapshot.addOnCompleteListener {
            if (it.isSuccessful) {
                // Document found in the offline cache
                val document = it.result?.documents?.map {
                    it.toObject(Produk::class.java)
                }
                all = document as List<Produk>

            } else {
                Log.d(TAG, "Cached get failed: ", it.exception)
            }
            bukuRecycleView.apply{
                layoutManager = GridLayoutManager(activity,2)
                adapter = BukuAdapter(all)
            }

            

        }

    }
}