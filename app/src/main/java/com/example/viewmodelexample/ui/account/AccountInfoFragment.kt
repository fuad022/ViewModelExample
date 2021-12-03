package com.example.viewmodelexample.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.viewmodelexample.data.remote.PostAdapter
import com.example.viewmodelexample.data.remote.PostViewModel
import com.example.viewmodelexample.data.remote.model.PostModel
import com.example.viewmodelexample.databinding.FragmentAccountInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountInfoFragment : Fragment() {
    private val binding by lazy { FragmentAccountInfoBinding.inflate(layoutInflater) }

    private val postViewModel: PostViewModel by viewModel()
    private val postAdapter = PostAdapter()
    private var postList = ArrayList<PostModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        return binding.root
    }

    private fun init() {
        postViewModel.myCustomPosts.observe(viewLifecycleOwner, { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    postList.addAll(it)
                    postAdapter.submitList(postList)
                }
            } else {
                Toast.makeText(activity, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        binding.recyclerView.adapter = postAdapter
    }
}


















