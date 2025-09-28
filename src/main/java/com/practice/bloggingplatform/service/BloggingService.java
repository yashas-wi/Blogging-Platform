package com.practice.bloggingplatform.service;
import com.practice.bloggingplatform.entity.Blogging;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BloggingService {
    private final List<Blogging> blogList;
    public BloggingService()
    {
        this.blogList = new ArrayList<>();
    }

    public String saveBlog(Blogging blogging){
//         AtomicInteger id;
//        id.incrementAndGet(); // safely increments
//        id.addAndGet(5);
        blogList.add(blogging);
        return "Blog has been saved successfully!";
    }

    public List<Blogging> getAllBlogging(){
        return blogList;
    }

    public String updateBlog(int id,String title,String content){
        for(Blogging blogging : blogList){
            if(blogging.getId() == id){
                blogging.setTitle(title);
                blogging.setContent(content);
                blogging.setUpdatedAt(LocalDateTime.now());
                return "Blog has been updated successfully!";
            }
        }throw new IllegalArgumentException("Invalid ID, Try again!");
    }


    public String deleteBlog(int id){
        for(Blogging blogging : blogList){
            if(blogging.getId() == id){
                blogList.remove(blogging);
                return "Blog has been deleted successfully!";
            }
        }
        throw new IllegalArgumentException("Incorrect ID.");
    }

//    public String getOneBlog(int id){
//        for(Blogging blogging : blogList){
//            if(blogging.getId() == id){
//
//            }
//        }
//    }
}
