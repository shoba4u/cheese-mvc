package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Andrew Bell on 3/8/17.
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    // Request path: GET /cheese
    // Returns index of cheeses
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    // Request path: GET /cheese/add
    // Returns add cheese form
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    // Request path: POST /cheese/add
    // Adds cheese
    // Redirects to index
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description) {
        cheeses.put(cheeseName, description);
        return "redirect:";
    }

    // Request path: POST /cheese/delete
    // Deletes cheeses
    // Redirects to index
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("delete") ArrayList<String> cheesesToDelete) {
        for (String cheeseToDelete : cheesesToDelete) {
            cheeses.remove(cheeseToDelete);
        }
        return "redirect:";
    }


}
