package dev.toastcie.lifeisshort.viewmodels.date

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import dev.toastcie.lifeisshort.usecases.compute.IComputeWeekConsumedUseCase
import dev.toastcie.lifeisshort.usecases.date.IGetDateFromStorageUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.LocalDate

class HomeViewModel(
    private val getDateFromStorageUseCase: IGetDateFromStorageUseCase,
    private val computeWeekConsumedUseCase: IComputeWeekConsumedUseCase
) : KMMViewModel() {

    private val _bornDate = MutableStateFlow<LocalDate?>(viewModelScope, null)
    private val _onBoardingShown = MutableStateFlow(viewModelScope, false)

    @NativeCoroutinesState
    val bornDate = _bornDate.asStateFlow()

    @NativeCoroutinesState
    val weekConsumed = _bornDate.map {
        it?.let { computeWeekConsumedUseCase(it) }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    @NativeCoroutinesState
    val onBoardingShown = _onBoardingShown.asStateFlow()

    fun calculateWeekConsumed() {
        _bornDate.value = getDateFromStorageUseCase() ?: run {
            _onBoardingShown.value = true
            null
        }
    }

    fun close() {
        _onBoardingShown.value = false
    }

}