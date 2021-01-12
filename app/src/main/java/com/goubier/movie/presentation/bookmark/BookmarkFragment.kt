package com.goubier.movie.presentation.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.goubier.movie.R
import com.goubier.movie.presentation.MainActivity
import com.goubier.movie.presentation.search.SearchAdapter

class BookmarkFragment : Fragment(), SearchAdapter.OnSearchItemClickListener {

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    private val viewModel: BookmarkViewModel by viewModels()

    private lateinit var adapter : SearchAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progress_bar)
        recyclerView = view.findViewById(R.id.recycler_view)

        adapter = SearchAdapter(requireContext(),this)
        recyclerView.adapter = adapter

        viewModel.state.observe(viewLifecycleOwner, ::updateState)

        viewModel.getBookmark()
    }

    private fun updateState(state: BookmarkState) {
        when (state) {
            is BookmarkState.ErrorState -> {
                progressBar.isVisible = false
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                adapter.setData(null)
            }
            is BookmarkState.LoadingState -> {
                progressBar.isVisible = true
                adapter.setData(null)
            }
            is BookmarkState.SuccessState -> {
                progressBar.isVisible = false
                adapter.setData(state.movies)
            }
        }
    }

    override fun onSearchItemClick(id: String) {
        val activity : MainActivity? = activity as? MainActivity

        activity?.displayMovieDetail(id)

    }

}
