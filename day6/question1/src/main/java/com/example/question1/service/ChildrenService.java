package com.example.question1.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.question1.model.Children;
import com.example.question1.repository.ChildrenRepo;

@Service
public class ChildrenService {
     private ChildrenRepo childrenRepo;
    public ChildrenService(ChildrenRepo childrenRepo){
        this.childrenRepo = childrenRepo;
    }

    public Children postChildren(Children children){
        if(children!=null){
            return childrenRepo.save(children);
        }
        else{
            throw new IllegalArgumentException("children cannot be null");
        }
    }

    public List<Children> sortChildren(String field){
        return childrenRepo.findAll(Sort.by(field));
    }

    public List<Children> childrenPagination(int offset, int pagesize){
       Page<Children> page = childrenRepo.findAll(PageRequest.of(offset, pagesize));
        return page.getContent();
    }

    public List<Children> childrenSortedPage(int offset, int pagesize, String field){
       PageRequest page = PageRequest.of(offset, pagesize, Sort.by(field));
       Page<Children> pageChildren = childrenRepo.findAll(page);
       return pageChildren.getContent();
    }

}
