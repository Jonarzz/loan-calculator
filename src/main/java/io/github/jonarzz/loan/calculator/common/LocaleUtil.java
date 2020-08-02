package io.github.jonarzz.loan.calculator.common;

import java.util.Locale;
import java.util.Optional;

import org.springframework.context.i18n.LocaleContextHolder;

public class LocaleUtil {

    private LocaleUtil() {
    }

    public static void save(String language) {
        LocaleContextHolder.setLocale(forTag(language));
    }

    public static Locale get() {
        return LocaleContextHolder.getLocale();
    }

    public static Locale forTag(String languageTag) {
        return Optional.ofNullable(languageTag)
                       .map(Locale::forLanguageTag)
                       .orElse(Locale.US);
    }

}
