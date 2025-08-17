package com.lostandfoundnetwork.lostandfound.service;

import com.lostandfoundnetwork.lostandfound.entity.ItemPost;
import java.util.List;
import java.util.Optional;

public interface ItemPostService {
    ItemPost createItemPost(ItemPost itemPost);
    List<ItemPost> getAllItemPosts();
    Optional<ItemPost> getItemPostById(Long id);
    ItemPost updateItemPost(Long id, ItemPost itemPostDetails);
    ItemPost patchItemPost(Long id, ItemPost partialUpdate);
    void deleteItemPost(Long id);
}
