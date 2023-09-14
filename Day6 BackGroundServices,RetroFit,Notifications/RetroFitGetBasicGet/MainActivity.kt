package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var tvField: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvField=findViewById(R.id.tvField);
        val retService:AlbumService=RetroFitInstance
            .getRestroFitInstance()
            .create(AlbumService::class.java)

        val responseLiveData:LiveData<Response<Album>> = liveData {
            val response=retService.getAlbums()
            emit(response)

        }


        responseLiveData.observe(this, Observer {
            val albumList=it.body()?.listIterator();
            if(albumList!=null){
                while(albumList.hasNext()){
                    val albumItem=albumList.next()
                    tvField.append(albumItem.title+"\n")
                    Log.i("MYTag",albumItem.title+"\n")
                }
            }
        })
    }
}