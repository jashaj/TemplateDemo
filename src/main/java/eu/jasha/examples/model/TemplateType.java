package eu.jasha.examples.model;

public enum TemplateType {
    FREEMARKER("freemarker"),
    JSP("jsp"),
    THYMELEAF("thymeleaf");

    private final String path;

    TemplateType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
