package com.idea3d.sexta.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.idea3d.sexta.R
import com.idea3d.sexta.core.TaskApp
import com.idea3d.sexta.data.model.DataSource
import com.idea3d.sexta.data.model.RepoImp
import com.idea3d.sexta.data.model.Task
import com.idea3d.sexta.databinding.ActivityMainBinding
import com.idea3d.sexta.ui.viewmodel.SharedViewModel
import com.idea3d.sexta.ui.viewmodel.VMFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<SharedViewModel>{VMFactory(RepoImp(DataSource()))}
//   se podría añadir cómo @Inject con Dagger

   private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        //navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        /*lifecycleScope.launch{
            val task = app.room.taskDao().GetAll()
            Log.d("", "onCreate:${task.size}task")
        }*/

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}