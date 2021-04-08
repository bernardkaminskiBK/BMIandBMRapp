package com.example.bmiandbmrapp.utils

import com.example.bmiandbmrapp.data.PersonData
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class FitnessCalculationsTest {

    lateinit var personDataMan: PersonData
    lateinit var personDataMan2: PersonData
    lateinit var personDataWoman: PersonData
    lateinit var personDataWoman2: PersonData

    lateinit var fitnessCalculationsMan: FitnessCalculations
    lateinit var fitnessCalculationsMan2: FitnessCalculations
    lateinit var fitnessCalculationsWoman: FitnessCalculations
    lateinit var fitnessCalculationsWoman2: FitnessCalculations

    @BeforeEach
    internal fun setUp() {
        personDataMan = PersonData("man", 32, 197, 102)
        personDataMan2 = PersonData("man", 50, 160, 85)
        personDataWoman = PersonData("woman", 32, 197, 102)
        personDataWoman2 = PersonData("woman", 50, 160, 85)

        fitnessCalculationsMan = FitnessCalculations(personDataMan)
        fitnessCalculationsMan2 = FitnessCalculations(personDataMan2)
        fitnessCalculationsWoman = FitnessCalculations(personDataWoman)
        fitnessCalculationsWoman2 = FitnessCalculations(personDataWoman2)
    }

    @Test
    fun age32Male102Weight197heightBmiIs26point3() {
        assertEquals(26.3, fitnessCalculationsMan.calculateBMI())
        assertEquals("Overweight", fitnessCalculationsMan.weightCategories() )
    }

    @Test
    fun age50Male85Weight160heightBmiIs33point2() {
        assertEquals(33.2, fitnessCalculationsMan2.calculateBMI())
        assertEquals("Obese (Class I)", fitnessCalculationsMan2.weightCategories() )
    }

    @Test
    fun age32Female102Weight197heightBmiIs26point3() {
        assertEquals(26.3, fitnessCalculationsMan.calculateBMI())
        assertEquals("Overweight", fitnessCalculationsMan.weightCategories() )
    }

    @Test
    fun age50Female85Weight160heightBmiIs33point2() {
        assertEquals(33.2, fitnessCalculationsMan2.calculateBMI())
        assertEquals("Obese (Class I)", fitnessCalculationsMan2.weightCategories() )
    }

    @Test
    fun age50Female85Weight160heightBmr1439() {
        assertEquals(1439, fitnessCalculationsWoman2.calculateBMR())
    }

}