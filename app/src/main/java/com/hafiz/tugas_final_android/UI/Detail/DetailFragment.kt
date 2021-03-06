package com.hafiz.tugas_final_android.UI.Detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hafiz.tugas_final_android.R
import com.hafiz.tugas_final_android.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_layout_list_news.view.*

class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var img  = ""+article!!.urlToImage
        if(img != "null" && img != "") {
            Picasso.get()
                .load(img)
                .into(newsImg)
        }

        newsTitle.text = article!!.title
        publisherNews.text = article!!.source.name
        descNews.text = ""+article!!.description
        contentNews.text = ""+article!!.content

        shareBtn.setOnClickListener {
            shareAction()
        }

        selengkapnyaBtn.setOnClickListener {
            val url = article!!.url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    private fun shareAction() {

        val text = "${article!!.title} - Baca selengkapnya di : ${article!!.url}"

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DetailFragment()
        var article : Article? = null
    }
}