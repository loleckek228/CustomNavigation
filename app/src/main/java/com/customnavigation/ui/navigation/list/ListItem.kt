package com.customnavigation.ui.navigation.list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
data class ListItem(val name: String) : Parcelable

class ListItemFactory {
    companion object {
        private const val ITEM_NAME = "Item"
        private const val FIRST_ELEMENT = 0
        private const val MIN_INTERVAL = 15
        private const val MAX_INTERVAL = 50

        val defaultItems: List<ListItem> by lazy { getItems() }

        private fun getItems(): List<ListItem> {
            val mutableList = mutableListOf<ListItem>()
            val randomCount = Random.nextInt(MIN_INTERVAL, MAX_INTERVAL)

            for (index in FIRST_ELEMENT..randomCount) {
                val name = "$ITEM_NAME $index"

                mutableList += ListItem(name)
            }

            return mutableList
        }
    }
}
