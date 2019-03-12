package com.example.flickrgallery.features.common

import android.view.View

internal fun <T: View> View.find(id: Int): T = findViewById(id)