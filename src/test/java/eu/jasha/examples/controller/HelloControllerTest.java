package eu.jasha.examples.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

import eu.jasha.examples.model.ExampleForm;

class HelloControllerTest {

  private HelloController controller;
  private ModelMap modelMap;

  @BeforeEach
  public void setUp() {
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
    final String view = controller.showForm("test", modelMap);
    assertEquals("index-test", view);
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

    final String view = controller.handleForm("test", form, modelMap);
    assertEquals("result-test", view);
    final ExampleForm fromModelMap = (ExampleForm) modelMap.get("form");
    assertSame(form, fromModelMap);
  }
}
