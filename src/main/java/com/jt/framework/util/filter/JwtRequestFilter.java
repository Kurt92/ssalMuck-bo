//package com.jt.framework.util.filter;
//
//import com.jt.framework.Security.service.UserInfoService;
//import com.jt.framework.util.cookie.CookieUtil;
//import com.jt.framework.util.jwt.JwtUtil;
//import com.jt.framework.util.redis.RedisUtil;
//import com.jt.ssalMuck.ctgy.member.dto.MemberDTO;
//import io.jsonwebtoken.ExpiredJwtException;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//@Component
//@AllArgsConstructor
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    private UserInfoService userInfoService;
//
//    private JwtUtil jwtUtil;
//
//    private CookieUtil cookieUtil;
//
//    private RedisUtil redisUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//
//        final Cookie jwtToken = cookieUtil.getCookie(httpServletRequest,JwtUtil.ACCESS_TOKEN_NAME);
//
//        String username = null;
//        String jwt = null;
//        String refreshJwt = null;
//        String refreshUname = null;
//
//        try{
//            if(jwtToken != null){
//                jwt = jwtToken.getValue();
//                username = jwtUtil.getUsername(jwt);
//            }
//            if(username!=null){
//                UserDetails userDetails = userInfoService.loadUserByUsername(username);
//
//
//                if(jwtUtil.validateToken(jwt,userDetails)){
//                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
//                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//                }
//            }
//        }catch (ExpiredJwtException e){
//            Cookie refreshToken = cookieUtil.getCookie(httpServletRequest,JwtUtil.REFRESH_TOKEN_NAME);
//            if(refreshToken!=null){
//                refreshJwt = refreshToken.getValue();
//            }
//        }catch(Exception e){
//
//        }
//
//        try{
//            if(refreshJwt != null){
//                refreshUname = redisUtil.getData(refreshJwt);
//
//                if(refreshUname.equals(jwtUtil.getUsername(refreshJwt))){
//                    UserDetails userDetails = userInfoService.loadUserByUsername(refreshUname);
//                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
//                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//
//                    MemberDTO member = new MemberDTO();
//                    member.setUsername(refreshUname);
//                    String newToken =jwtUtil.generateToken(member);
//
//                    Cookie newAccessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME,newToken);
//                    httpServletResponse.addCookie(newAccessToken);
//                }
//            }
//        }catch(ExpiredJwtException e){
//
//        }
//
//        filterChain.doFilter(httpServletRequest,httpServletResponse);
//    }
//}
