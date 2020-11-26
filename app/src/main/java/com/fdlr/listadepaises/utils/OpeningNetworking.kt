package com.fdlr.listadepaises.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

object OpeningNetworking {
    fun openNetwork(
        context: Context,
        appPackage: String,
        appAddress: String,
        webAddress: String
    ) {

        val uri = Uri.parse(appAddress)
        val intent = Intent(Intent.ACTION_VIEW, uri)

        intent.setPackage(appPackage)

        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            /*
             * Se não houver o aplicativo da rede
             * social acionada, então abra a página
             * no navegador padrão do aparelho, Web.
             * */
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(webAddress)
                )
            )
        }
    }
}