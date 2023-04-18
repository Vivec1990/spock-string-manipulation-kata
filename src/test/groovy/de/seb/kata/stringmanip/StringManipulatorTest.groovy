package de.seb.kata.stringmanip

import spock.lang.Specification

import static de.seb.kata.stringmanip.FormatOption.*
import static de.seb.kata.stringmanip.StringManipulator.format

class StringManipulatorTest extends Specification {

    def "all upper"(String text, String expected) {
        when:
        def result = format(text, ALL_UPPER)

        then:
        result == expected

        where:
        text                       | expected
        "This is a test"           | "THIS IS A TEST"
        "alles klein"              | "ALLES KLEIN"
        "drei woerter alles gross" | "DREI WOERTER ALLES GROSS"
        "CaMeL CaSe"               | "CAMEL CASE"
    }

    def "all lower"(String text, String expected) {
        when:
        def result = format(text, ALL_LOWER)

        then:
        result == expected

        where:
        text                       | expected
        "This is a test"           | "this is a test"
        "alles klein"              | "alles klein"
        "drei woerter alles gross" | "drei woerter alles gross"
        "CaMeL CaSe"               | "camel case"
    }

    def "camel case"(String text, String expected) {
        when:
        def result = format(text, CAMEL_CASE)

        then:
        result == expected

        where:
        text                       | expected
        "This is a test"           | "This Is A Test"
        "alles klein"              | "Alles Klein"
        "drei woerter alles gross" | "Drei Woerter Alles Gross"
        "CaMeL CaSe"               | "Camel Case"
    }

    def "alternating"(String text, String expected) {
        when:
        def result = format(text, ALTERNATING)

        then:
        result == expected

        where:
        text                       | expected
        "This is a test"           | "tHiS iS a TeSt"
        "alles klein"              | "aLlEs KlEiN"
        "drei woerter alles gross" | "dReI wOeRtEr AlLeS gRoSs"
        "CaMeL CaSe"               | "cAmEl CaSe"
    }

    def "diff alternating"(String text, String expected) {
        when:
        def result = format(text, DIFF_ALTERNATING)

        then:
        result == expected

        where:
        text                       | expected
        "This is a test"           | "ThIs Is A tEsT"
        "alles klein"              | "AlLeS kLeIn"
        "drei woerter alles gross" | "DrEi WoErTeR aLlEs GrOsS"
        "CaMeL CaSe"               | "CaMeL cAsE"
    }

    def "alternating word"(String text, String expected) {
        when:
        def result = format(text, ALTERNATING_WORD)

        then:
        result == expected

        where:
        text                       | expected
        "This is a test"           | "this IS a TEST"
        "alles klein"              | "alles KLEIN"
        "drei woerter alles gross" | "drei WOERTER alles GROSS"
        "CaMeL CaSe"               | "camel CASE"
    }

    def "diff alternating word"(String text, String expected) {
        when:
        def result = format(text, DIFF_ALTERNATING_WORD)

        then:
        result == expected

        where:
        text                       | expected
        "This is a test"           | "THIS is A test"
        "alles klein"              | "ALLES klein"
        "drei woerter alles gross" | "DREI woerter ALLES gross"
        "CaMeL CaSe"               | "CAMEL case"
    }

}
