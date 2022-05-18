package ru.itis.kurguskina.springsemworkinternet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itis.kurguskina.springsemworkinternet.dto.UserDto;
import ru.itis.kurguskina.springsemworkinternet.security.details.AccountUserDetails;
import ru.itis.kurguskina.springsemworkinternet.service.UserService;


import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProfileController {

//    private final ArticleService postService;

    private final UserService userService;

//    private final FileService fileService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mainpage")
    public String getProfilePage(@AuthenticationPrincipal AccountUserDetails userDetails, Model model) {
        Optional<UserDto> userByEmail = userService.getUsersByEmail(userDetails.getUsername());
        if (userByEmail.isPresent()) {
            UserDto account = userByEmail.get();
            model.addAttribute("account", account);
        }
        return "blogauth";
    }

//    @PreAuthorize("isAuthenticated()")
//    @PostMapping("profile/{account-id}/post")
//    public String addPost(@PathVariable("account-id") Long accountId, @Valid ArticleDto post, BindingResult result) {
//        if (result.hasErrors()) {
//            return "redirect:/profile";
//        }
//        postService.addPost(post, accountId);
//        return "redirect:/profile";
//    }

    @GetMapping("/userPage")
    public String getUserPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "account";
    }

    @PostMapping("/userPage")
    public String updateUserPage(@Valid UserDto userDto, BindingResult result, @AuthenticationPrincipal AccountUserDetails userDetails, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "account";
        }
        String email = userDetails.getUsername();
        userService.update(userDto, email);
        return "blogauth";
    }

//    @GetMapping("/profile/files/{filename}")
//    public void getFile(@PathVariable(name = "filename") String storageFileName, HttpServletResponse response) {
//        fileService.getFileByStorageName(storageFileName, response);
//    }

//    @PostMapping("profile/files/{account-id}/upload")
//    public String uploadAvatar(@PathVariable(name = "account-id") Long accountId, @RequestParam("file") MultipartFile multipartFile) {
//        if (multipartFile.getOriginalFilename().isEmpty()) {
//            return "redirect:/profile";
//        }
//        fileService.uploadAvatar(multipartFile, accountId);
//        return "redirect:/profile";
//    }
}

