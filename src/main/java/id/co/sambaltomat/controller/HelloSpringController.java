package id.co.sambaltomat.controller;

import id.co.sambaltomat.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: HP
 * Date: 10/28/13
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HelloSpringController {

    @Autowired
    public TestModel testModel;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", testModel.getHelloModel());
        return "output";
    }

}
