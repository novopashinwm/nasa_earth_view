package com.skillbox.android.nasa_earth_view.ui.ListPhotos

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.skillbox.android.nasa_earth_view.R
import com.skillbox.android.nasa_earth_view.adapter.ListPhotosAdapter
import com.skillbox.android.nasa_earth_view.other.autoCleared
import com.skillbox.android.nasa_earth_view.other.toast
import com.skillbox.android.nasa_earth_view.ui.ListDates.ListDatesViewModel
import jp.wasabeef.recyclerview.animators.ScaleInRightAnimator
import kotlinx.android.synthetic.main.fragment_photos.*

class ListPhotosFragment : Fragment(R.layout.fragment_photos) {

    val viewModel : ListDatesViewModel by viewModels()
    var listPhotosAdapter: ListPhotosAdapter by autoCleared()
    private val args: ListPhotosFragmentArgs by navArgs()


    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        bindViewModel()

    }

    override fun onResume() {
        super.onResume()
        Handler().post {
            viewModel.getPhotesByDates(args.dateId)
        }
    }

    private fun showDetail(postion: Int) {

    }

    private fun initList() {

        listPhotosAdapter = ListPhotosAdapter  (onItemClick = { position ->
            showDetail(position)
        })
        reposList.apply {
            adapter = listPhotosAdapter
            itemAnimator = ScaleInRightAnimator()
            layoutManager = LinearLayoutManager(requireContext())

            setHasFixedSize(true)
        }
    }

    private fun bindViewModel() {

        viewModel.photosList.observe(viewLifecycleOwner, Observer {
            listPhotosAdapter.items = it
        })

        viewModel.onError.observe(viewLifecycleOwner, Observer {
            toast("Во время загрузки случилась ошибка: $it")
        })
    }
}