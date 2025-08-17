package com.lostandfoundnetwork.lostandfound.service;

import com.lostandfoundnetwork.lostandfound.entity.ItemPost;
import com.lostandfoundnetwork.lostandfound.repository.ItemPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPostServiceImpl implements ItemPostService{
    private final ItemPostRepository itemPostRepository;

    // USING CONSTRUCTOR INJECTION TO INJECT DEPENDENCIES
    public ItemPostServiceImpl(ItemPostRepository itemPostRepository){
        this.itemPostRepository = itemPostRepository;
    }

    @Override
    public ItemPost createItemPost(ItemPost itemPost) {
        return itemPostRepository.save(itemPost);
    }

    @Override
    public List<ItemPost> getAllItemPosts() {
        return itemPostRepository.findAll();
    }

    @Override
    public Optional<ItemPost> getItemPostById(Long id) {
        return itemPostRepository.findById(id);
    }

    @Override
    public ItemPost updateItemPost(Long id, ItemPost itemPostDetails) {
        ItemPost itemPost = itemPostRepository.findById(id).orElseThrow(() -> new RuntimeException("Item Post Not Found with id: "+ id));

        itemPost.setTitle(itemPostDetails.getTitle());
        itemPost.setDescription(itemPostDetails.getDescription());
        itemPost.setStatus(itemPostDetails.getStatus());
        itemPost.setLocation(itemPostDetails.getLocation());
        // IMAGE URL updates
        itemPost.setImageUrl(itemPostDetails.getImageUrl());
        return itemPostRepository.save(itemPost);
    }

    @Override
    public ItemPost patchItemPost(Long id, ItemPost partialUpdate) {
        ItemPost itemPost = itemPostRepository.findById(id).orElseThrow(()-> new RuntimeException("Item Post Not Found with id : "+ id));

        if(partialUpdate.getStatus() != null) itemPost.setStatus(partialUpdate.getStatus());
        if(partialUpdate.getTitle() != null) itemPost.setTitle(partialUpdate.getTitle());
        if(partialUpdate.getLocation()!= null) itemPost.setLocation(partialUpdate.getLocation());
        if(partialUpdate.getDescription() != null) itemPost.setDescription(partialUpdate.getDescription());
        if(partialUpdate.getImageUrl() != null) itemPost.setImageUrl(partialUpdate.getImageUrl());

        return itemPostRepository.save(itemPost);
    }

    @Override
    public void deleteItemPost(Long id) {
        itemPostRepository.deleteById(id);
    }

}
