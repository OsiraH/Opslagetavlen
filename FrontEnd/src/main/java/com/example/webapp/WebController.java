package com.example.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WebController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String welcome() {
        return "Hello World!";
    }

    @GetMapping("/home")
    public ModelAndView homeView() {
        // Create a ModelAndView object
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home"); // Specifies the view (e.g., home.jsp)
        return mav;
    }

    /**
     * Process the form submission.
     *
     * @param u user object that was filled out on the form page
     * @param result handles error messages to send back to the view, if necessary
     * @param m spring-injected model object that gets filled and sent to the view
     * @return the view to display
     */
   /* @RequestMapping(method=RequestMethod.POST)
    public String processFormSubmission(@ModelAttribute("user") User u, BindingResult result, Model m) {
        log.info("Calling processFormSubmission()");

        validator.validate(u, result);
        if (result.hasErrors()) {
            // error occured, lets send them back to the form to re-enter their information
            return "form";
        }

        m.addAttribute("status", "Your submission was a success!");

        return "result";
    }*/
}
