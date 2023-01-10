package com.visualnuts.exercises;

import com.visualnuts.exercises.list.Country;
import com.visualnuts.exercises.list.Exercise2;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Exercise2Test {

    private Exercise2 exercise2;
    private Country[] countriesSet1;
    private Country[] countriesSet2;
    private Country[] countriesSet3;
    private Country[] countriesSet4;
    private Country[] emptyCountrySet;

    @Before
    public void before() {
        exercise2 = new Exercise2();

        countriesSet1 = new Country[]{
                new Country("FR", Arrays.asList("fr", "en", "de")),
                new Country("DE", Arrays.asList("de", "en")),
                new Country("ES", Arrays.asList("es", "en"))
        };

        countriesSet2 = new Country[]{
                new Country("USA", Arrays.asList("en", "es")),
                new Country("CA", Arrays.asList("en", "fr")),
                new Country("MX", List.of("es"))
        };

        countriesSet3 = new Country[]{new Country("USA", Arrays.asList("en", "es"))};

        countriesSet4 = new Country[] {
                new Country("DE", Arrays.asList("de", "en")),
                new Country("ES", Arrays.asList("es", "de")),
                new Country("AU", List.of("de"))
        };

        emptyCountrySet = new Country[0];
    }

    /*Testing 1*/
    @Test
    public void testNumberOfCountries() {
        // Test case 1: Test with an array of countries

        int result = exercise2.numberOfCountries(countriesSet1);
        assertEquals(3, result);

        // Test case 2: Test with an empty array of countries
        result = exercise2.numberOfCountries(emptyCountrySet);
        assertEquals(0, result);

        // Test case 3: Test with an array of countries with size 1
        result = exercise2.numberOfCountries(countriesSet3);
        assertEquals(1, result);
    }

    /*Testing 2*/
    @Test
    public void testCountryWithMostOfficialLanguagesThatSpeakGerman() {
        // Test case 1: At least one country that speaks German as an official language
        List<Country> result = exercise2.countryWithMostOfficialLanguagesThatSpeakGerman(countriesSet1);
        assertEquals(1, result.size());
        assertEquals("FR", result.get(0).getCountry());


        // Test case 2: No country that speaks German as an official language
        result = exercise2.countryWithMostOfficialLanguagesThatSpeakGerman(countriesSet2);
        assertEquals(0,result.size());

        // Test case 3: Multiple countries that speak German as an official language
        result = exercise2.countryWithMostOfficialLanguagesThatSpeakGerman(countriesSet4);
        assertEquals(2, result.size());
        assertEquals("DE", result.get(0).getCountry());
        assertEquals("ES", result.get(1).getCountry());
    }

    /*Testing 3*/
    @Test
    public void testAllOfficialLanguagesInTheListedCountries() {
        // Test case 1: Test with an array of countries
        Set<String> result = exercise2.allOfficialLanguagesInTheListedCountries(countriesSet1);

        assertEquals(4,result.size());
        assertTrue(result.contains("fr"));
        assertTrue(result.contains("en"));
        assertTrue(result.contains("de"));
        assertTrue(result.contains("es"));

        // Test case 2: Test with an empty array of countries
        result = exercise2.allOfficialLanguagesInTheListedCountries(emptyCountrySet);
        assertTrue(result.isEmpty());

        // Test case 3: Test with an array of countries with no repeated languages
        result = exercise2.allOfficialLanguagesInTheListedCountries(countriesSet4);
        assertEquals(3,result.size());
        assertTrue(result.contains("en"));
        assertTrue(result.contains("de"));
        assertTrue(result.contains("es"));

        // Test case 4: Test with an array of countries with repeated languages
        result = exercise2.allOfficialLanguagesInTheListedCountries(countriesSet2);
        assertEquals(3,result.size());
        assertTrue(result.contains("en"));
        assertTrue(result.contains("fr"));
        assertTrue(result.contains("es"));
    }


    /*Testing 4*/
    @Test
    public void testFindTheCountryWithTheHighestNumberOfOfficialLanguages() {
         Country france = new Country("FR", Arrays.asList("fr", "en", "de"));
         Country usa = new Country("USA", Arrays.asList("en", "es"));
         Country canada = new Country("CA", Arrays.asList("en", "fr"));

         // Test Case 1: Test with only one Country with higher number of official languages
        List<Country> result = exercise2.findTheCountryWithMostOfficialLanguages(countriesSet1);
        assertEquals(france.getCountry(), result.get(0).getCountry());

        // Test Case 2: Test with two countries with same higher number of official languages
        result = exercise2.findTheCountryWithMostOfficialLanguages(countriesSet2);
        assertEquals(usa.getCountry(), result.get(0).getCountry());
        assertEquals(canada.getCountry(), result.get(1).getCountry());

        // Test Case 3: Test with no data
        result = exercise2.findTheCountryWithMostOfficialLanguages(emptyCountrySet);
        assertTrue(result.isEmpty());
    }

    /*Testing 5*/
    @Test
    public void testFindMostCommonOfficialLanguages() {

        // Test Case 1: find one most common language:
        List<String> result = exercise2.findMostCommonOfficialLanguages(countriesSet1);
        assertEquals("en", result.get(0));

        // Test Case 2: find with no languages
        result = exercise2.findMostCommonOfficialLanguages(emptyCountrySet);
        assertTrue(result.isEmpty());

        // Test Case 3: find with more than one common languages
        result = exercise2.findMostCommonOfficialLanguages(countriesSet2);
        assertTrue(result.contains("es"));
        assertTrue(result.contains("en"));

    }
}
