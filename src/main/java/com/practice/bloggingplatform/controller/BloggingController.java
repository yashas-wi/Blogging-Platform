package com.practice.bloggingplatform.controller;
import com.practice.bloggingplatform.entity.Blogging;
import com.practice.bloggingplatform.service.BloggingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BloggingController {
    private final BloggingService bloggingService;
    public BloggingController(BloggingService bloggingService) {
        this.bloggingService = bloggingService;
    }

    @PostMapping("/saveBlog")
    public ResponseEntity<String> saveBlogging(@RequestBody Blogging blogging) {
        try {
            String response = bloggingService.saveBlog(blogging);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listOfBlogs")
    public ResponseEntity<List<Blogging>> getAllBlogging() {
        try {
            List<Blogging> response = bloggingService.getAllBlogging();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/updateBlog")
    public ResponseEntity<String> updateBlogging(@RequestParam int id ,@RequestParam String title, @RequestParam String content) {
        try{
            String response = bloggingService.updateBlog(id ,title ,content);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/deleteBlog")
    public ResponseEntity<String> deleteBlogging(@RequestParam int id) {
        try{
            String response = bloggingService.deleteBlog(id);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("getOneBlog")
    public ResponseEntity<Blogging> getOneBlog(@RequestParam int id) {
        try{
            Blogging response = bloggingService.getOneBlog(id);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
