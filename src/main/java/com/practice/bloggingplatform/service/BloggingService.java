package com.practice.bloggingplatform.service;
import com.practice.bloggingplatform.dto.BlogDto;
import com.practice.bloggingplatform.entity.Blog;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BloggingService {
    private final List<Blog> blogList;
    private final AtomicInteger id =  new AtomicInteger(0);
    public BloggingService()
    {
        this.blogList = new ArrayList<>();
    }

    public String saveBlog(BlogDto blogDto){

        blogList.add(new Blog(id.incrementAndGet(), blogDto.title(), blogDto.content(), blogDto.category()));
        return "Blog has been saved successfully!";
    }

    public List<Blog> getAllBlogging(){
        return blogList;
    }

    public String updateBlog(int id,String title,String content){
        for(Blog blog : blogList){
            if(blog.getId() == id){
                blog.setTitle(title);
                blog.setContent(content);
                blog.setUpdatedAt(LocalDateTime.now());
                return "Blog has been updated successfully!";
            }
        }throw new IllegalArgumentException("Invalid ID, Try again!");
    }


    public String deleteBlog(int id){
        for(Blog blog : blogList){
            if(blog.getId() == id){
                blogList.remove(blog);
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
