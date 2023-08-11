package com.ckenergy.cet.core.compose

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.ckenergy.cet.core.AutoTrackHelper

/**
 * @author ckenergy
 * @date 2023/6/8
 * @desc
 */
class CETDestinationChangedListener: NavController.OnDestinationChangedListener {

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        val trace = "compose route：${destination.route}"
        Log.d("destinationChanged", trace)
        AutoTrackHelper.trackViewScreen(trace)
    }

    companion object{
        @JvmStatic
        fun register(controller: NavController) {
            controller.addOnDestinationChangedListener(CETDestinationChangedListener())
        }
    }
}