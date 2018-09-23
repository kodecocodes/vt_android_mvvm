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

package com.raywenderlich.android.creaturemon.model

object AttributeStore {
  val INTELLIGENCE: List<AttributeValue> by lazy {
    val avatars = mutableListOf<AttributeValue>()
    avatars.add(AttributeValue("None"))
    avatars.add(AttributeValue("Aristotle", 3))
    avatars.add(AttributeValue("Newton", 7))
    avatars.add(AttributeValue("Einstein", 10))
    avatars
  }
  val STRENGTH: List<AttributeValue> by lazy {
    val avatars = mutableListOf<AttributeValue>()
    avatars.add(AttributeValue("None"))
    avatars.add(AttributeValue("Thor", 3))
    avatars.add(AttributeValue("Hulk", 7))
    avatars.add(AttributeValue("Hercules", 10))
    avatars
  }
  val ENDURANCE: List<AttributeValue> by lazy {
    val avatars = mutableListOf<AttributeValue>()
    avatars.add(AttributeValue("None"))
    avatars.add(AttributeValue("Aluminum", 3))
    avatars.add(AttributeValue("Gold", 7))
    avatars.add(AttributeValue("Iron", 10))
    avatars
  }
}