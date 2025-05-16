package com.example.foodappgamb.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.foodappgamb.Domain.BannerModel
import com.example.foodappgamb.Domain.CategoryModel
import com.example.foodappgamb.Domain.FoodModel
import com.example.foodappgamb.Repository.MainRepository

class MainViewModel:ViewModel() {
    private val repository=MainRepository()


    fun loadBanner():LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }

    fun loadCategory():LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }

    fun loadFiltered(id:String):LiveData<MutableList<FoodModel>>{
        return repository.loadFilterd(id)
    }
}