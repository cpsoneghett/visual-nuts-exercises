package com.visualnuts.exercises.list;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise2 {

    public void run() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File("src/main/resources/input.json");
        Country[] countries = mapper.readValue(jsonFile, Country[].class);

        // 1. Return the number of countries in the world
        System.out.println("1. Number of countries: " + numberOfCountries(countries));

        // 2. Find the country with the most official languages that speaks German
        List<Country> countryWithMostOfficialLanguagesThatSpeakGerman = countryWithMostOfficialLanguagesThatSpeakGerman(countries);

        if (countryWithMostOfficialLanguagesThatSpeakGerman.isEmpty()) {
            System.out.println("2. No country was found that speaks German as an official language.");
        } else {
            String countryOrCountries = countryWithMostOfficialLanguagesThatSpeakGerman.size() > 1 ? "countries" : "country";
            System.out.printf("2. The %s with most languages that speak German are: %s%n", countryOrCountries, countryWithMostOfficialLanguagesThatSpeakGerman);
        }

        // 3. Count all the official languages spoken in the listed countries
        Set<String> officialLanguages = allOfficialLanguagesInTheListedCountries(countries);
        System.out.println("3. All official languages: " + officialLanguages + " - Total: " + officialLanguages.size());


        // 4. Find the country with the highest number of official languages
        List<Country> countryWithMostOfficialLanguages = findTheCountryWithMostOfficialLanguages(countries);
        if (countryWithMostOfficialLanguages != null)
            System.out.println("4. The country (or countries) with most number of Official Languages is/are: " + countryWithMostOfficialLanguages);

        // 5. Find the most common official language(s)
        List<String> mostCommonLanguage = findMostCommonOfficialLanguages(countries);
        if (!mostCommonLanguage.isEmpty()) {
            System.out.println("5. Most common language: " + mostCommonLanguage);
        } else {
            System.out.println("5. No language was found in the data.");
        }
    }


    // 1. Return the number of countries in the world
    public int numberOfCountries(Country[] countries) {
        return countries.length;
    }

    // 2. Find the country with the most official languages that speaks German
    public List<Country> countryWithMostOfficialLanguagesThatSpeakGerman(Country[] countries) {
        List<Country> countryList = new ArrayList<>();
        int maxLanguages = 0;
        boolean speaksGerman;

        for (Country country : countries) {
            speaksGerman = country.getLanguages().stream().anyMatch("de"::equals);

            if (speaksGerman) {
                if (country.getLanguages().size() > maxLanguages) {
                    maxLanguages = country.getLanguages().size();
                    countryList.clear();
                    countryList.add(country);
                } else if (country.getLanguages().size() == maxLanguages) {
                    countryList.add(country);
                }
            }
        }
        return countryList;
    }

    // 3. Count all the official languages spoken in the listed countries
    public Set<String> allOfficialLanguagesInTheListedCountries(Country[] countries) {
        Set<String> officialLanguages = new HashSet<>();
        for (Country country : countries)
            officialLanguages.addAll(country.getLanguages());

        return officialLanguages;
    }

    // 4. Find the country with the highest number of official languages
    public List<Country> findTheCountryWithMostOfficialLanguages(Country[] countries) {
        int maxLanguages = 0;
        List<Country> countryWithMostLanguages = new ArrayList<>();
        for (Country country : countries) {
            if (country.getLanguages().size() > maxLanguages) {
                maxLanguages = country.getLanguages().size();
                countryWithMostLanguages.clear();
                countryWithMostLanguages.add(country);
            } else if (country.getLanguages().size() == maxLanguages) {
                countryWithMostLanguages.add(country);
            }
        }
        return countryWithMostLanguages;
    }

    // 5. Find the most common official language(s)
    public List<String> findMostCommonOfficialLanguages(Country[] countries) {

        Map<String, Long> languageCounts = new HashMap<>();
        for (Country country : countries) {
            for (String language : country.getLanguages()) {
                languageCounts.merge(language, 1L, Long::sum);
            }
        }
        // return languageCounts.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(null);
        long maxValue = languageCounts.values().stream().max(Long::compare).orElse(0l);
        return languageCounts.entrySet().stream().filter(entry -> entry.getValue() == maxValue).map(Map.Entry::getKey).collect(Collectors.toList());
    }

}

