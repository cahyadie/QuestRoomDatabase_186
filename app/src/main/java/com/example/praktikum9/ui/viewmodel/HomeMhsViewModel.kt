package com.example.praktikum9.ui.viewmodel
import androidx.lifecycle.ViewModel
import com.example.praktikum9.data.entity.Mahasiswa
import com.example.praktikum9.repository.RepositoryMhs


class HomeMhsViewModel()



data class HomeUiState(
    val listMhs: List<Mahasiswa> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessages: String = ""
)


class DetailMhsViewModel()


data class DetailUiState(
    val detailUiEvent : MahasiswaEvent = MahasiswaEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessages: String = ""
){
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == MahasiswaEvent()

    val isUiEventNotEmpty : Boolean
        get() = detailUiEvent != MahasiswaEvent()
}

fun Mahasiswa.toDtailUiEvent() : MahasiswaEvent {
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        jenisKelamin = jenisKelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan
    )
}