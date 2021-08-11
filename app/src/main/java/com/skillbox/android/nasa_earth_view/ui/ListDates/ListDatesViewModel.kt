package com.skillbox.android.nasa_earth_view.ui.ListDates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skillbox.android.nasa_earth_view.data.DateDTO
import com.skillbox.android.nasa_earth_view.data.PhotoDTO
import com.skillbox.android.nasa_earth_view.other.SingleLiveEvent
import kotlinx.coroutines.launch

class ListDatesViewModel : ViewModel()  {
    private val repository = ListDatesRepo()

    private val datesLiveData = MutableLiveData<List<DateDTO>>(emptyList())
    private val photosByData = MutableLiveData<List<PhotoDTO>>(emptyList())
    private val isLoadingLiveData = MutableLiveData<Boolean>(false)
    private val onErrorLiveData = SingleLiveEvent<String>()

    val datesList: LiveData<List<DateDTO>>
        get() = datesLiveData

    val photosList : LiveData<List<PhotoDTO>>
        get() = photosByData

    val isLoading: LiveData<Boolean>
        get() = isLoadingLiveData

    val onError: SingleLiveEvent<String>
        get() = onErrorLiveData

    fun getDatesList() {
        viewModelScope.launch {
            isLoadingLiveData.postValue(true)
            try {
                val dates = repository.getDates()
                dates.subscribe {
                    it -> datesLiveData.postValue(it)
                }

            } catch (t: Throwable) {
                datesLiveData.postValue(emptyList())
            }
            finally {
                isLoadingLiveData.postValue(false)
            }
        }
    }

    fun getPhotesByDates(date: String) {
        viewModelScope.launch {
            isLoadingLiveData.postValue(true)
            try {
                val photos = repository.getPhotosForDate(date)
                photos.subscribe {
                        it -> photosByData.postValue(it)
                }

            } catch (t: Throwable) {
                photosByData.postValue(emptyList())
            }
            finally {
                isLoadingLiveData.postValue(false)
            }
        }
    }

}