package com.hafiz.tugas_final_android.UI.List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hafiz.tugas_final_android.R
import com.hafiz.tugas_final_android.UI.Detail.DetailFragment
import com.hafiz.tugas_final_android.adapter.NewsAdapter
import com.hafiz.tugas_final_android.model.Article
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariable()

        lifecycleScope.launch {
            viewModel.getLatestNews(adapter)
        }
    }

    private fun initVariable() {
        adapter = NewsAdapter(object : NewsAdapter.Listener {
            override fun onItemClick(article: Article) {
                DetailFragment.article = article
                findNavController().navigate(R.id.action_listFragment_to_detailFragment)
            }
        })
        rcView_news.setHasFixedSize(true)
        rcView_news.layoutManager = LinearLayoutManager(requireContext())
        rcView_news.adapter = adapter
    }


    companion object {

        @JvmStatic
        fun newInstance() = ListFragment()
    }
}