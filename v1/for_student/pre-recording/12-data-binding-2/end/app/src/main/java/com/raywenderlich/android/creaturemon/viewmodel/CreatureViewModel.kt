/*
 * Copyright (c) 2018 Razeware LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish, 
 * distribute, sublicense, create a derivative work, and/or sell copies of the 
 * Software in any work that is designed, intended, or marketed for pedagogical or 
 * instructional purposes related to programming, coding, application development, 
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works, 
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.creaturemon.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.raywenderlich.android.creaturemon.model.*
import com.raywenderlich.android.creaturemon.model.room.RoomRepository

class CreatureViewModel(private val generator: CreatureGenerator = CreatureGenerator(),
                        private val repository: CreatureRepository = RoomRepository()) : ViewModel() {

  private val creatureLiveData = MutableLiveData<Creature>()
  private val saveLiveData = MutableLiveData<Boolean>()

  fun getCreatureLiveData(): LiveData<Creature> = creatureLiveData
  fun getSaveLiveData(): LiveData<Boolean> = saveLiveData

  var name = ObservableField<String>("")
  var intelligence = 0
  var strength = 0
  var endurance = 0
  var drawable = 0

  lateinit var creature: Creature

  fun updateCreature() {
    val attributes = CreatureAttributes(intelligence, strength, endurance)
    creature = generator.generateCreature(attributes, name.get() ?: "", drawable)
    creatureLiveData.postValue(creature)
  }

  fun attributeSelected(attributeType: AttributeType, position: Int) {
    when (attributeType) {
      AttributeType.INTELLIGENCE ->
        intelligence = AttributeStore.INTELLIGENCE[position].value
      AttributeType.STRENGTH ->
        strength = AttributeStore.STRENGTH[position].value
      AttributeType.ENDURANCE ->
        endurance = AttributeStore.ENDURANCE[position].value
    }
    updateCreature()
  }

  fun drawableSelected(drawable: Int) {
    this.drawable = drawable
    updateCreature()
  }

  fun saveCreature() {
    return if (canSaveCreature()) {
      repository.saveCreature(creature)
      saveLiveData.postValue(true)
    } else {
      saveLiveData.postValue(false)
    }
  }

  fun canSaveCreature(): Boolean {
    val name = this.name.get()
    name?.let {
      return intelligence != 0 && strength != 0 && endurance != 0 &&
          name.isNotEmpty() && drawable != 0
    }
    return false
  }
}