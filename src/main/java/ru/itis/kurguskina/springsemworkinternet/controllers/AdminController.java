package ru.itis.kurguskina.springsemworkinternet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.kurguskina.springsemworkinternet.models.User;
import ru.itis.kurguskina.springsemworkinternet.service.ArticleService;
import ru.itis.kurguskina.springsemworkinternet.service.UserService;


@RequiredArgsConstructor
@Controller
@RequestMapping("/accounts")
public class AdminController {

    private final UserService userService;
    private final ArticleService articleService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getUserPage(Model model) {
        model.addAttribute("accounts", userService.getAllUsers());
        return "accounts";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{account-id}/delete")
    public String deleteAccount(@PathVariable("account-id") Long id) {
        userService.deleteUser(id);
        return "redirect:/accounts";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("student") User user) {
        userService.saveUser(user);
        return "{\"status\":\"success\"}";
    }

//
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public List<User> listStudents() {
//        List<User> liststudent = userService.listAll();
//        return liststudent;
//    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("new");
        User user = userService.getUserById(id);
        mav.addObject("accounts", user);
        return mav;

    }

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @RequestMapping("/delete/{id}")
//    public String deletestudent(@PathVariable(name = "id") int id) {
//        userService.delete(id);
//        return "redirect:/";
//    }

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping
//    public String getAllArticles() {
//        return "articles";
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @PostMapping("/{article-id}/delete")
//    public String deleteArticle(@PathVariable("article-id") Long articleId) {
//        articleService.deleteArticle(articleId);
//        return "redirect:/articles";
//    }

}
