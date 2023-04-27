package eu.jasha.examples.controller;

import eu.jasha.examples.model.ExampleForm;
import eu.jasha.examples.model.TemplateType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

  @GetMapping
  public String home(final ModelMap modelMap) {
    return showForm(TemplateType.JSP, modelMap);
  }

  @GetMapping("favicon.ico")
  @ResponseBody
  public void favicon() {
    // No favicon
  }

  @GetMapping(value = "{template}")
  public String showForm(@PathVariable(value = "template") final TemplateType template,
                         final ModelMap model) {
    final List<String> words = List.of("Aap", "<marquee>Noot</marquee>", "Mies");
    model.addAttribute("words", words);
    final ExampleForm form = new ExampleForm();
    form.setWord("Mies");
    model.addAttribute("form", form);
    return String.format("index-%s", template.getPath());
  }

  @PostMapping(value = "{template}")
  public String handleForm(@PathVariable(value = "template") final TemplateType template,
                           @ModelAttribute("form") final ExampleForm formBean,
                           final ModelMap modelMap) {
    modelMap.addAttribute("form", formBean);

    return String.format("result-%s", template.getPath());
  }
}