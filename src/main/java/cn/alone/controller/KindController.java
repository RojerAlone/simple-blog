package cn.alone.controller;

import cn.alone.services.IKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "{kid}", method = RequestMethod.GET)
    public String kind(@PathVariable Integer kid) {
        this.getModel().addAttribute("kind", kindService.selectById(kid));
        return "kind";
    }

}
