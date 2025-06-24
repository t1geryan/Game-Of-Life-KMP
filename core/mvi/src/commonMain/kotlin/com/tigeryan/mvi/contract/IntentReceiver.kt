package com.tigeryan.mvi.contract

/**
 * Interface that intent receivers implement specifying a specific intent class
 */
interface IntentReceiver<I : Intent> {

    fun receive(intent: I)
}