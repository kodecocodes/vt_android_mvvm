package com.raywenderlich.android.creaturemon.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.raywenderlich.android.creaturemon.model.Creature
import com.raywenderlich.android.creaturemon.model.CreatureAttributes
import com.raywenderlich.android.creaturemon.model.CreatureGenerator
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class CreatureViewModelTest {

  private lateinit var creatureViewModel: CreatureViewModel

  @get:Rule
  var rule: TestRule = InstantTaskExecutorRule()

  @Mock
  lateinit var mockGenerator: CreatureGenerator

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)
    creatureViewModel = CreatureViewModel(mockGenerator)
  }

  @Test
  fun testSetupCreature() {
    val attributes = CreatureAttributes(10, 3, 7)
    val stubCreature = Creature(attributes, 87, "Test Creature")
    `when`(mockGenerator.generateCreature(attributes)).thenReturn(stubCreature)

    creatureViewModel.intelligence = 10
    creatureViewModel.strength = 3
    creatureViewModel.endurance = 7

    creatureViewModel.updateCreature()

    assertEquals(stubCreature, creatureViewModel.creature)
  }
}