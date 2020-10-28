package eu.jasha.examples.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import eu.jasha.examples.model.ExampleForm;

@Controller
@RequestMapping("/")
public class HelloController {

  @GetMapping
  public String home(final ModelMap modelMap) {
    return showForm("jsp", modelMap);
  }

  @GetMapping("favicon.ico")
  @ResponseBody
  public void favicon() {
    // No favicon
  }

  @GetMapping(value = "{template}")
  public String showForm(@PathVariable(value = "template") final String template,
                         final ModelMap model) {
    final List<String> words = List.of("Aap", "<marquee>Noot</marquee>", "Mies");
    model.addAttribute("words", words);
    final ExampleForm form = new ExampleForm();
    form.setWord("Mies");
    model.addAttribute("form", form);
    return "index-" + template;
  }

  @PostMapping(value = "{template}")
  public String handleForm(@PathVariable(value = "template") final String template,
                           @ModelAttribute("form") final ExampleForm formBean,
                           final ModelMap modelMap) {
    modelMap.addAttribute("form", formBean);
    return "result-" + template;
  }
}