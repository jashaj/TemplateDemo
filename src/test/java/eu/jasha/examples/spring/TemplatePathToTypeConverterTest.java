package eu.jasha.examples.spring;

import eu.jasha.examples.model.TemplateType;
import org.junit.jupiter.api.Test;

import static eu.jasha.examples.model.TemplateType.FREEMARKER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TemplatePathToTypeConverterTest {
    private final TemplatePathToTypeConverter converter = new TemplatePathToTypeConverter();

    @Test
    void shouldFailToConvertArbitraryValue() {
        assertThrows(IllegalArgumentException.class, () -> converter.convert("random"));
    }

    @Test
    void shouldConvertPathToType() {
        TemplateType templateType = converter.convert(FREEMARKER.getPath());

        assertEquals(FREEMARKER, templateType);
    }
}