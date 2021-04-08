package com.example.bmiandbmrapp.utils

import com.example.bmiandbmrapp.data.PersonData

class FitnessCalculations(private val personData: PersonData) {

    private val UNDER_WEIGHT: Double = 18.5
    private val HEALTHY_WEIGHT: Double = 24.9
    private val OVER_WEIGHT: Double = 29.9
    private val OBESE: Double = 34.9
    private val SEVERELY_OBESE: Double = 39.9
    private val MORBIDLY_OBESE: Double = 49.9
    private val SUPER_OBESE: Double = 49.9

    fun calculateBMI(): Double {
        val bmi = personData.weight.toDouble() /
                ((personData.height.toDouble() / 100)
                        * (personData.height.toDouble() / 100))
        return Math.round(bmi * 10) / 10.0
    }

    fun calculateBMR(): Long {
        val bmr: Double
        if (personData.gender.equals("man")) {
            bmr = 10 * personData.weight + 6.25 * personData.height - 5 * personData.age + 5
        } else {
            bmr = 10 * personData.weight + 6.25 * personData.height - 5 * personData.age - 161
        }
        return Math.round(bmr)
    }

    fun weightCategories(): String {
        return when (calculateBMI()) {
            in 0.0..UNDER_WEIGHT -> "Underweight"
            in UNDER_WEIGHT..HEALTHY_WEIGHT -> "Healthy Weight"
            in HEALTHY_WEIGHT..OVER_WEIGHT -> "Overweight"
            in OVER_WEIGHT..OBESE -> "Obese (Class I)"
            in OBESE..SEVERELY_OBESE -> "Severely Obese (Class II)"
            in SEVERELY_OBESE..MORBIDLY_OBESE -> "Morbidly Obese (Class III)"
            in MORBIDLY_OBESE..SUPER_OBESE -> "Super Obese (Class IV)"
            else -> "I might be wrong but maybe you are a very special person :-D"
        }
    }

}