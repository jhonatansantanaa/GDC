package br.com.gdc

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import br.com.gdc.databinding.ActivityMainBinding
import br.com.gdc.feature.data.entity.TaskDto
import br.com.gdc.feature.presenter.TaskListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  lateinit var viewModel : TaskListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider (
            this,
            TaskListViewModel.TaskViewModelFactory(MyApplication.instance)
        ).get(TaskListViewModel::class.java)

        viewModel.alltasks.observe(this) {
            Log.d("MyTaskList", it.toString())
            Toast.makeText(
                this,
                it.size.toString(),
                Toast.LENGTH_LONG
            ).show()
        }
        viewModel.addTask(TaskDto(name = "test task"))
    }
}