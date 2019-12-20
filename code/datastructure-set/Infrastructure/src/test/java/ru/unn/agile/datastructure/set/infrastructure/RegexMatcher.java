package ru.unn.agile.datastructure.set.infrastructure;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class RegexMatcher extends BaseMatcher {
    private final String regex;

    private RegexMatcher(final String regex) {
        this.regex = regex;
    }

    public boolean matches(final Object o) {
        return ((String) o).matches(regex);
    }

    public void describeTo(final Description description) {
        description.appendText("matches regex = ");
        description.appendText(regex);
    }

    @SuppressWarnings(value = "unchecked")
    static Matcher<? super String> matchesPattern(final String regex) {
        return (Matcher<? super String>) new RegexMatcher(regex);
    }
}
