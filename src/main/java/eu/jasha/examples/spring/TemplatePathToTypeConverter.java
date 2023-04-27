package eu.jasha.examples.spring;

import eu.jasha.examples.model.TemplateType;
import org.springframework.core.convert.converter.Converter;

public class TemplatePathToTypeConverter implements Converter<String, TemplateType> {
    @Override
    public TemplateType convert(String source) {
        return TemplateType.valueOf(source.toUpperCase());
    }
}

