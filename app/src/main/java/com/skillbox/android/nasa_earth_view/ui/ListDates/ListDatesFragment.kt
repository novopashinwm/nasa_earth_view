package com.skillbox.android.nasa_earth_view.ui.ListDates
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.skillbox.android.nasa_earth_view.R
import com.skillbox.android.nasa_earth_view.adapter.ListDatesAdapter
import com.skillbox.android.nasa_earth_view.other.autoCleared
import com.skillbox.android.nasa_earth_view.other.toast
import kotlinx.android.synthetic.main.fragment_dates.*

class ListDatesFragment : Fragment(R.layout.fragment_dates) {

    val viewModel : ListDatesViewModel by viewModels()
    var listDatesAdapter: ListDatesAdapter by autoCleared()

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        bindViewModel()
    }

    override fun onResume() {
        super.onResume()

        Handler().post {
            viewModel.getDatesList()
        }
    }

    private fun showDetail(position: Int) {
        //Переход в детальную информацию репозитория
        //val action = RepositoryListFragmentDirections.actionRepositoryListFragmentToDetailRepoFragment(position)
        //findNavController().navigate(action)
        val date = listDatesAdapter.items[position].date
        val action = ListDatesFragmentDirections.actionListDatesFragmentToListPhotosFragment(date)
        findNavController().navigate(action)

    }

    private fun initList() {
        listDatesAdapter = ListDatesAdapter (onItemClick = { position ->
            showDetail(position)
        })
        reposList.apply {
            adapter = listDatesAdapter
            //layoutManager = LinearLayoutManager(requireContext())
            layoutManager = GridLayoutManager(requireContext(),2)
            setHasFixedSize(true)
        }
    }

    private fun bindViewModel() {

        viewModel.datesList.observe(viewLifecycleOwner, Observer {
            listDatesAdapter.items = it
        })

        viewModel.onError.observe(viewLifecycleOwner, Observer {
            toast("Во время загрузки случилась ошибка: $it")
        })
    }
}