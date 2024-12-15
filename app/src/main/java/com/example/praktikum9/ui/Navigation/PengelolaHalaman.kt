package com.example.praktikum9.ui.Navigation

import HomeMhsView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Update
import com.example.praktikum9.ui.view.mahasiswa.DestinasiInsert
import com.example.praktikum9.ui.view.mahasiswa.DetailMhsView
import com.example.praktikum9.ui.view.mahasiswa.InsertMhsView
import com.example.praktikum9.ui.view.mahasiswa.UpdateMhsView
import com.example.praktikum9.ui.viewmodel.HomeMhsViewModel

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
   NavHost(navController = navController,
       startDestination = DestinasiHome.route) {
       composable(
           route = DestinasiHome.route
       ){
           HomeMhsView(
               onDetailClick = {nim ->
                   navController.navigate("${DestinasiDetail.route}/$nim")
                   println(
                       "PengelolaanHalaman: nim = $nim"
                   )
               },
               onAddMhs = {
                   navController.navigate(DestinasiInsert.route)
               },
               modifier = Modifier
           )
       }

       composable(
           route = DestinasiInsert.route
       ){
           InsertMhsView(
               onBack = {
                   navController.popBackStack()
               },
               onNavigate = {
                   navController.popBackStack()
               },
               modifier = Modifier,
           )
       }

       composable(
           DestinasiDetail.routeWithArg,
           arguments = listOf(
               navArgument(DestinasiDetail.NIM){
                   type = NavType.StringType
               }
           )
       ){
           val nim = it.arguments?.getString(DestinasiDetail.NIM)
           nim?.let {nim ->
               DetailMhsView(
                   onBack = {
                       navController.popBackStack()
                   },
                   onEditClick = {
                       navController.navigate("${DestinasiUpdate.route}/$it")
                   },
                   modifier = Modifier,
                   onDeleteClick = {
                       navController.popBackStack()
                   }
               )
           }
       }
       composable(
           DestinasiUpdate.routeWithArg,
           arguments = listOf(
               navArgument(DestinasiUpdate.NIM){
                   type = NavType.StringType
               }
           )
       ){
           UpdateMhsView(
               onBack = {
                   navController.popBackStack()
               },
               onNavigate = {
                   navController.popBackStack()
               },
               modifier = Modifier
           )
       }
   }
}