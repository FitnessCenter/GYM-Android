package com.dsm.gym.presentation.base

import androidx.lifecycle.Lifecycle

interface LifecycleCallback {
    fun apply(event: Lifecycle.Event)
}