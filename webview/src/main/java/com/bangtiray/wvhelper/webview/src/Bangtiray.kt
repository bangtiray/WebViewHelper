package com.bangtiray.wvhelper.webview.src

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat

object Bangtiray {
    private var customTabHelper: TabHelper = TabHelper()
    fun showWebView(context: Context, url: String, customLabel: String, showTitle: Boolean) {
        val builder = CustomTabsIntent.Builder()

        // modify toolbar color
        builder.setToolbarColor(
            ContextCompat.getColor(
                context,
                android.R.color.holo_blue_dark
            )
        )
        builder.addDefaultShareMenuItem()

        val anotherCustomTab = CustomTabsIntent.Builder().build()
        val requestCode = 100
        val intent = anotherCustomTab.intent
        intent.data = Uri.parse(url)

        val pendingIntent = PendingIntent.getActivity(
            context,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        builder.addMenuItem(customLabel, pendingIntent)
        builder.setShowTitle(showTitle)
        builder.setStartAnimations(context, android.R.anim.fade_in, android.R.anim.fade_out)
        builder.setExitAnimations(context, android.R.anim.fade_in, android.R.anim.fade_out)

        val customTabsIntent = builder.build()

        val packageName = customTabHelper.getPackageNameToUse(context, url)

        customTabsIntent.intent.setPackage(packageName)
        customTabsIntent.intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        customTabsIntent.launchUrl(context, Uri.parse(url))

    }
}