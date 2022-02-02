package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController {

    @RequestMapping(value = "")
    public String search(Model model) {
        return "search";
    }

    // Create a handler to process a search request and render the updated search view.

    @PostMapping("results")
    public String displaySearchResults (Model model,
                                        String searchType,
                                        String searchTerm) {
        List<Job> jobs = searchTerm.equals("all") ?
                JobData.findAll() :
                JobData.findByColumnAndValue(searchType, searchTerm);
        model.addAttribute("searchType", searchType);
        model.addAttribute("jobs", jobs);
        return "search";
    }
}
