package com.example.pharmalink.data.retroClient

import android.util.Log
import com.example.pharmalink.api.MedicationApiService
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.dto.MedicationDTO
import com.example.pharmalink.data.mapper.ApiMapper
import com.example.pharmalink.data.mapper.MedicationDC
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InternetService {
    private const val BASE_URL = "https://my.api.mockaroo.com/"
    const val API_KEY = "2d08d690"

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // logs headers + body
    }

    private val okHttp: OkHttpClient by lazy {

        OkHttpClient.Builder()
            .addInterceptor {
                    chain ->
                val origin = chain.request()
                val newUrl = origin.url.newBuilder()
                    .addQueryParameter("key",
                        API_KEY
                    )
                    .build()
                Log.d("URL", newUrl.toString())
                val newRequest = origin.newBuilder()
                    .url(newUrl)
                    .build()
                chain.proceed(newRequest)
            }
            .addInterceptor(logging)
            .build()

    }

    //retrofit
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()

    }

    //medication request
    val medicationApiService: MedicationApiService by lazy {
        retrofit.create(MedicationApiService::class.java)
    }

    //map database data to domain class
    val medicationMapper: ApiMapper<Medication, MedicationDTO> by lazy {
        MedicationDC()
    }

}