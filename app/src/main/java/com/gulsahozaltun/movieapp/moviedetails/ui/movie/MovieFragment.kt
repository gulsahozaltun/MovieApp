package com.gulsahozaltun.movieapp.moviedetails.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.gulsahozaltun.movieapp.R
import com.gulsahozaltun.movieapp.databinding.FragmentMovieBinding
import com.gulsahozaltun.movieapp.moviedetails.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {
    lateinit var binding: FragmentMovieBinding

    val viewModel: MovieViewModel by viewModels()


    val movieAdapter = MoviePagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setRecyclerView()
        binding.movieSearch.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.setQuery(it)
                    Log.e("gelen veriler",query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })


        viewModel.list.observe(viewLifecycleOwner) {
            movieAdapter.submitData(lifecycle, it)

        }


    }

    private fun setRecyclerView() {
        binding.movieRecycler.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }


}






/*
private lateinit var binding:FragmentMovieBinding
val viewModel:MovieViewModel by viewModels()
val adapter= MoviePagingAdapter()
override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    binding=DataBindingUtil.inflate(inflater,R.layout.fragment_movie, container, false)

    viewModel.list.observe(viewLifecycleOwner){
        adapter.submitData(lifecycle,it)
        binding.recyclerObj=adapter
    }

    return binding.root
}

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(query: String?): Boolean {
            query?.let {
                viewModel.setQuery(it)
            }
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }

    })

}
}
*/

