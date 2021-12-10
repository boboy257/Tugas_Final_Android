package com.hafiz.tugas_final_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hafiz.tugas_final_android.R
import com.hafiz.tugas_final_android.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout_list_news.view.*

class NewsAdapter(): RecyclerView.Adapter<NewsAdapter.Holder>() {

    private var listNews = mutableListOf<Article>()

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(article: Article) {
            with(itemView) {
                var img  = ""+article.urlToImage
                if(img != "null" && img != "") {
                    Picasso.get()
                        .load(img)
                        .into(thumbnailNews)
                }

                titleNews.text = article.title
                publisherNews.text = article.source.name
            }
        }
    }

    fun setData(list: MutableList<Article>) {
        this.listNews = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_list_news, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listNews[position])
    }

    override fun getItemCount(): Int {
        return listNews.size
    }


}