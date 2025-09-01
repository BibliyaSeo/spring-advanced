package org.example.expert.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.expert.domain.user.enums.UserRole;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class AdminApiLoggingAspect {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Around("execution(* org.example.expert.domain.comment.controller.CommentAdminController.*(..)) || " +
            "execution(* org.example.expert.domain.user.controller.UserAdminController.*(..))")
    public Object logAdminApi(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Long userId = (Long) request.getAttribute("userId");
        String roleStr = (String) request.getAttribute("userRole");
        UserRole userRole = roleStr != null ? UserRole.of(roleStr) : null;

        String requestUrl = request.getRequestURI();
        String requestTime = LocalDateTime.now().toString();

        // 요청 본문
        Object[] args = joinPoint.getArgs();
        String requestBody = "";
        for (Object arg : args) {
            if (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)) {
                try {
                    requestBody = objectMapper.writeValueAsString(arg);
                } catch (Exception e) {
                    requestBody = arg.toString();
                }
            }
        }

        log.info("API 요청: userId={}, role={}, time={}, url={}, body={}",
                userId != null ? userId : "anonymous",
                userRole != null ? userRole : "unknown",
                requestTime,
                requestUrl,
                requestBody);

        Object result = joinPoint.proceed();

        // 응답 본문
        String responseBody = "";
        try {
            responseBody = objectMapper.writeValueAsString(result);
        } catch (Exception e) {
            responseBody = String.valueOf(result);
        }

        log.info("API 응답: userId={}, role={}, time={}, url={}, response={}",
                userId != null ? userId : "anonymous",
                userRole != null ? userRole : "unknown",
                LocalDateTime.now(),
                requestUrl,
                responseBody);

        return result;
    }
}
