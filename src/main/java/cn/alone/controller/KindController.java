package cn.alone.controller;

import cn.alone.services.IKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RojerAlone on 2017/5/8.
 */
@Controller
@RequestMapping(value = "/kind")
public class KindController extends AbstractController {

    @Autowired
    private IKindService kindService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String allKind() {
        this.getModel().addAttribute("kinds", kindService.getAllKind());
        return "kinds";
    }

}
