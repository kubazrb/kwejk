package pl.edu.wat.pze.kwejk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wat.pze.kwejk.model.ViewEnum;
import pl.edu.wat.pze.kwejk.service.ArticleService;
import pl.edu.wat.pze.kwejk.service.PictureService;

@Controller
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/{pictureId}")
    public String getArticle(@PathVariable Long pictureId, Model aModel) {

        aModel.addAttribute("activeView", ViewEnum.VIEW);
        aModel.addAttribute("actualPicture", pictureService.getPictureById(pictureId));

        return "index";
    }

}
