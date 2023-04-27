package eu.jasha.examples.controller;

import eu.jasha.examples.model.ExampleForm;
import eu.jasha.examples.model.TemplateType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

  private HelloController controller;
  private ModelMap modelMap;

  @BeforeEach
  void setUp() {
    controller = new HelloController();
    modelMap = new ModelMap();
  }

  @Test
  void should_return_jsp_view() {
    final String view = controller.home(modelMap);

    assertEquals("index-jsp", view);
  }

  @Test
  void should_return_other_view() {
    final String view = controller.showForm(TemplateType.JSP, modelMap);

    assertEquals("index-jsp", view);

    final ExampleForm form = (ExampleForm) modelMap.get("form");
    assertNull(form.getName());
    assertNull(form.getEmail());
    assertNotNull(form.getWord());

    assertFalse(((List<?>) modelMap.get("words")).isEmpty());
  }

  @Test
  void should_handle_form_submit() {
    final ExampleForm form = new ExampleForm();
    form.setName("John Doe");
    form.setEmail("john@example.com");
    form.setWord("junit");

    final String view = controller.handleForm(TemplateType.JSP, form, modelMap);

    assertEquals("result-jsp", view);

    final ExampleForm fromModelMap = (ExampleForm) modelMap.get("form");
    assertSame(form, fromModelMap);
  }
}
