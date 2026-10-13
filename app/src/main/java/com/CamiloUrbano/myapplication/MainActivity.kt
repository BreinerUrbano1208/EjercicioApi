package com.CamiloUrbano.myapplication
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load // Usamos Coil para cargar la imagen fácilmente

class MainActivity : AppCompatActivity() {

    // Inicializamos el ViewModel con la extensión by viewModels()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a tus vistas en el XML
        val imageView: ImageView = findViewById(R.id.imageViewDog)
        val btnFetch: Button = findViewById(R.id.btnGetDog)

        // Observamos el LiveData del ViewModel para enterarnos cuando llegue la URL
        viewModel.dogImageUrl.observe(this) { url ->
            if (!url.isNullOrEmpty()) {
                // Pintamos la imagen en el ImageView usando Coil
                imageView.load(url)
            }
        }

        // Al presionar el botón, llamamos a la función del ViewModel
        btnFetch.setOnClickListener {
            viewModel.getRandomDogImage()
        }
    }
}