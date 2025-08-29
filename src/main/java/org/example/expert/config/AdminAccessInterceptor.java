package org.example.expert.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.expert.domain.user.enums.UserRole;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Slf4j
@Component
public class AdminAccessInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        Long userId = (Long) request.getAttribute("userId");
        String roleStr = (String) request.getAttribute("userRole");
        UserRole userRole = roleStr != null ? UserRole.of(roleStr) : null;

        // 관리자 권한 체크
        if (userRole != UserRole.ADMIN) {
            log.warn("접근 차단: 관리자가 아님 userId={}", userId != null ? userId : "anonymous");
            throw new IllegalStateException("관리자 권한이 필요합니다.");
        }

        log.info("접근 허용: userId={}, role={}, time={}, url={}",
                userId,
                userRole,
                LocalDateTime.now(),
                request.getRequestURI());

        return true;
    }
}
