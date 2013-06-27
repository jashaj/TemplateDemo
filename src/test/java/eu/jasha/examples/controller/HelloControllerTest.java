package eu.jasha.examples.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import eu.jasha.examples.model.ExampleForm;

public class HelloControllerTest {

  private HelloController controller;
  private ModelMap modelMap;

  @Before
  public void setUp() throws Exception {
    controller = new HelloController();
    modelMap = new ModelMap();
  }

  @Test
  public void should_return_jsp_view() throws Exception {
    final String view = controller.home(modelMap);
    assertEquals("index-jsp", view);
  }

  @Test
  public void should_return_other_view() throws Exception {
    final String view = controller.showForm("test", modelMap);
    assertEquals("index-test", view);
    final ExampleForm form = (ExampleForm) modelMap.get("form");
    assertNull(form.getName());
    assertNull(form.getEmail());
    assertNotNull(form.getWord());
    assertFalse(((List) modelMap.get("words")).isEmpty());
  }

  @Test
  public void should_handle_form_submit() throws Exception {
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
