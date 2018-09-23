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

package com.raywenderlich.android.creaturemon.view.avatars

import com.raywenderlich.android.creaturemon.R
import com.raywenderlich.android.creaturemon.model.Avatar

object AvatarStore {
  val AVATARS: List<Avatar> by lazy {
    val avatars = mutableListOf<Avatar>()

    avatars.add(Avatar(R.drawable.creature_app_whistle_1))
    avatars.add(Avatar(R.drawable.creature_bear_sleepy))
    avatars.add(Avatar(R.drawable.creature_bird_blue_fly_1))
    avatars.add(Avatar(R.drawable.creature_bug_insect_happy))
    avatars.add(Avatar(R.drawable.creature_bug_spider))
    avatars.add(Avatar(R.drawable.creature_cat_derp))
    avatars.add(Avatar(R.drawable.creature_cow_01))
    avatars.add(Avatar(R.drawable.creature_dino_01))
    avatars.add(Avatar(R.drawable.creature_dog_bone))
    avatars.add(Avatar(R.drawable.creature_duck_yellow_1))
    avatars.add(Avatar(R.drawable.creature_frog_hungry))
    avatars.add(Avatar(R.drawable.creature_head_fox))
    avatars.add(Avatar(R.drawable.creature_head_pig))
    avatars.add(Avatar(R.drawable.creature_head_tiger))
    avatars.add(Avatar(R.drawable.creature_monkey_happy))
    avatars.add(Avatar(R.drawable.creature_monster_purple))
    avatars.add(Avatar(R.drawable.creature_monster_slug))
    avatars.add(Avatar(R.drawable.creature_monster_yeti_1))
    avatars.add(Avatar(R.drawable.creature_owl_attack_1))
    avatars.add(Avatar(R.drawable.creature_panda_fun))
    avatars.add(Avatar(R.drawable.creature_penguin_plane))
    avatars.add(Avatar(R.drawable.creature_rat))
    avatars.add(Avatar(R.drawable.creature_skunk))
    avatars.add(Avatar(R.drawable.creature_square_bunny))
    avatars.add(Avatar(R.drawable.creature_wolf_crazy))

    avatars
  }
}