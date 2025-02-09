package org.example.expert.domain.comment.dto.response;

import lombok.Getter;
import org.example.expert.domain.comment.entity.Comment;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.entity.User;

@Getter
public class CommentSaveResponse {

    private final Long id;
    private final String contents;
    private final UserResponse user;

    public CommentSaveResponse(Comment savedComment, User user) {
        this.id = savedComment.getId();
        this.contents = savedComment.getContents();
        this.user = new UserResponse(user.getId(), user.getEmail());
    }
}
