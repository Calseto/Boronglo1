package com.borong

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.borong.data.DataKategori
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val DaftarKategori = DataKategori().allCategory()
        view.QRScannerButton.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToQRScanner()
            view.findNavController().navigate(action)

        }
        CategoryRecyclerView.apply{
            layoutManager = GridLayoutManager(activity,2)
            adapter = KategoriAdapter(DaftarKategori)
        }

    }
}