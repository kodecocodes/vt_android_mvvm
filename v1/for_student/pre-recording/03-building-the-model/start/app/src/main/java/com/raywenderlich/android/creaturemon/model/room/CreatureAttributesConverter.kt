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

package com.raywenderlich.android.creaturemon.model.room

import android.arch.persistence.room.TypeConverter
import com.raywenderlich.android.creaturemon.model.CreatureAttributes
import java.util.*

class CreatureAttributesConverter {
  @TypeConverter
  fun fromCreatureAttributes(attributes: CreatureAttributes?): String? {
    if (attributes != null) {
      return String.format(Locale.US, "%d,%d,%d", attributes.intelligence, attributes.strength, attributes.endurance)
    }
    return null
  }

  @TypeConverter
  fun toCreatureAttributes(value: String?): CreatureAttributes? {
    if (value != null) {
      val pieces = value.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
      return CreatureAttributes(
          java.lang.Integer.parseInt(pieces[0]),
          java.lang.Integer.parseInt(pieces[1]),
          java.lang.Integer.parseInt(pieces[2]))
    }
    return null
  }
}