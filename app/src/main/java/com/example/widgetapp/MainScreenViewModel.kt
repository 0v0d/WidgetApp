package com.example.widgetapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    userRepository: UserRepository
) : ViewModel() {

    private val _userImage = MutableStateFlow<String?>(null)
    val userImage = _userImage.asStateFlow()

    init {
        viewModelScope.launch {
            _userImage.value = userRepository.getRandomUserImage()
        }
    }
}