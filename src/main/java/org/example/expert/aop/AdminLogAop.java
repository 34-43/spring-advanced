package org.example.expert.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.example.expert.domain.user.dto.request.UserRoleChangeRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j(topic = "Admin Log")
@Component
@Aspect
public class AdminLogAop {
    @Pointcut("execution(* org.example.expert.domain.user.controller.UserAdminController.*(..))")
    public void forUserAdminController() {
    }

    @Pointcut("execution(* org.example.expert.domain.comment.controller.CommentAdminController.*(..))")
    public void forCommentAdminController() {
    }

    @Pointcut("forUserAdminController() || forCommentAdminController()")
    public void forAdminController() {
    }

    @Around("forAdminController()")
    public Object logAdminAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();

        Long id = (Long) joinPoint.getArgs()[0];
        UserRoleChangeRequest dto = (UserRoleChangeRequest) joinPoint.getArgs()[1];

        log.info("\nAdmin 요청 > 요청자 ID: {}, \n요청 시각: {}, \n요청 URL: {}, \n요청 본문 : {}", id, LocalDateTime.now(), "/admin/users/" + id, mapper.writeValueAsString(dto));

        try {

            Object result = joinPoint.proceed();
            // After
            log.info("Admin 응답 > 응답 객체 : {},", result);
            return result;
        } catch (Exception ex) {

            log.error("Admin 예외 > {}", ex.getMessage(), ex);
            throw ex;
        }
    }
}
