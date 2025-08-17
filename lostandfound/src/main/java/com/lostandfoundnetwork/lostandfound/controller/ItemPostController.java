package com.lostandfoundnetwork.lostandfound.controller;

import com.lostandfoundnetwork.lostandfound.entity.ItemPost;
import com.lostandfoundnetwork.lostandfound.service.ItemPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // combines @Controller and @ResponseBody , marking this class for RESTful services
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:5173")// Maps all requests starting with /api/posts to this controller
public class ItemPostController {
    private final ItemPostService itemPostService;

    public ItemPostController(ItemPostService itemPostService){
        this.itemPostService = itemPostService;
    }

    /**
     * POST /api/posts : CREATE A NEW LOST OR FOUND ITEM POST
     * */
    @PostMapping // Maps HTTP POST requests to this method.
    public ItemPost createItemPost(@RequestBody ItemPost itemPost){
        return itemPostService.createItemPost(itemPost);
    }

    /**
     *
     * GET /api/posts : RETRIEVE ALL ITEM POSTS
     * */
    @GetMapping // Maps HTTP GET requests to this method.
    public List<ItemPost> getAllItemPosts(){
        return itemPostService.getAllItemPosts();
    }

    /**
     *
     * GET /api/posts/{id} : Retrieve a single item post by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ItemPost> getItemPostById(@PathVariable Long id){
        return itemPostService.getItemPostById(id)
                .map(ResponseEntity::ok) //If found, return 200 OK with the item.
                .orElse(ResponseEntity.notFound().build()); // If not found, return 404 Not Found.
    }
    /**
     * PUT /api/posts/{id} : Update an existing item post.
     * */
    @PutMapping("/{id}")
    public ResponseEntity<ItemPost> updateItemPost(@PathVariable Long id, @RequestBody ItemPost itemPostDetails){
        try{
            ItemPost updatedPost = itemPostService.updateItemPost(id, itemPostDetails);
            return ResponseEntity.ok(updatedPost);
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    /**
     *  PATCH /api/posts/{id} : Partially update an existing item post.
     *  Only the provided fields will be updated.
     * */

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPost> patchItemPost(@PathVariable Long id, @RequestBody ItemPost partialUpdate){
        try{
            ItemPost updatedPost = itemPostService.patchItemPost(id, partialUpdate);
            return ResponseEntity.ok(updatedPost);
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/posts/{id} : DELETE an item POST
     * */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemPost(@PathVariable Long id){
        itemPostService.deleteItemPost(id);
        return ResponseEntity.noContent().build(); // Return 204 No content on Successful deletion.
    }


}
