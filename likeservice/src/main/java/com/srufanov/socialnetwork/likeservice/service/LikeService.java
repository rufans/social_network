package com.srufanov.socialnetwork.likeservice.service;

import com.srufanov.socialnetwork.likeservice.entity.Like;
import com.srufanov.socialnetwork.likeservice.entity.LikeId;
import com.srufanov.socialnetwork.likeservice.repository.LikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public int getLikeCountForPost(long postId) {
        return likeRepository.countByLikeIdPostId(postId);
    }

    /**
     * Add like to post for a user if it's not exist. Otherwise remove it
     *
     * @param postId post id to add/remove like to/from
     * @param userId id of a user who does like action
     */
    @Transactional
    public void handleLikeAction(Long postId, Long userId) {
        LikeId likeId = new LikeId(postId, userId);
        Optional<Like> likeOptional = likeRepository.findById(likeId);

        likeOptional.ifPresentOrElse(likeRepository::delete, () -> addLike(likeId));
    }

    private void addLike(LikeId likeId) {
        Like like = new Like(likeId);
        likeRepository.save(like);
    }
}
