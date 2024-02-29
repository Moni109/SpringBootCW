package com.example.question1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question1.model.Children;
import com.example.question1.service.ChildrenService;

@RestController
@RequestMapping("/api/children")
public class ChildrenController {
    private ChildrenService childrenService;
    public ChildrenController(ChildrenService childrenService){
        this.childrenService = childrenService;
    }

    @PostMapping
    public ResponseEntity<Children> createChildren(@RequestBody Children children){
        Children ch = childrenService.postChildren(children);
        if(ch!=null){
            return new ResponseEntity<>(ch,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(ch,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/sortBy/{field}")
    public ResponseEntity<List<Children>> getChildren(@PathVariable String field){
        List<Children> ch = childrenService.sortChildren(field);
        if(ch!=null){
            return new ResponseEntity<>(ch,HttpStatus.OK);
        }
        return new ResponseEntity<>(ch,HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/{offset}/{pagesize}")
    public ResponseEntity<List<Children>> getPage(@PathVariable int offset, @PathVariable int pagesize){
        List<Children> ch = childrenService.childrenPagination(offset, pagesize);
        if(ch!=null){
            return new ResponseEntity<>(ch,HttpStatus.OK);
        }
        return new ResponseEntity<>(ch,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Children>> getSortedPage(@PathVariable int offset, @PathVariable int pagesize,@PathVariable String field){
        List<Children> ch = childrenService.childrenSortedPage(offset, pagesize,field);
        if(ch!=null){
            return new ResponseEntity<>(ch,HttpStatus.OK);
        }
        return new ResponseEntity<>(ch,HttpStatus.NOT_FOUND);
    }


}
