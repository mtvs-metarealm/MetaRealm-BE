package com.metarealm.metarealm_be.security.auth.filter;

import com.metarealm.metarealm_be.exception.InvalidTokenException;
import com.metarealm.metarealm_be.exception.TokenNotFoundException;
import com.metarealm.metarealm_be.exception.UnexpectedSecurityException;
import com.metarealm.metarealm_be.security.auth.model.DetailsUser;
import com.metarealm.metarealm_be.security.common.AuthConstants;
import com.metarealm.metarealm_be.security.common.OhgiraffersRole;
import com.metarealm.metarealm_be.security.common.utils.TokenUtils;
import com.metarealm.metarealm_be.security.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        /*
         * 권한이 필요없는 리소스
         * */
        try {
            List<String> roleLeessList = Arrays.asList(
                "/signup"
            );

            if (roleLeessList.contains(request.getRequestURI())) {
                chain.doFilter(request, response);
                return;
            }

            String header = request.getHeader(AuthConstants.AUTH_HEADER);

            if (header != null && !header.equalsIgnoreCase("")) {
                String token = TokenUtils.splitHeader(header);

                if (TokenUtils.isValidToken(token)) {
                    Claims claims = TokenUtils.getClaimsFormToken(token);

                    DetailsUser authentication = new DetailsUser();
                    User user = new User();
                    user.setUserName(claims.get("userName").toString());

//                user.setUserEmail(claims.get("userEmail").toString());
                    user.setRole(OhgiraffersRole.valueOf(claims.get("Role").toString()));
                    authentication.setUser(user);

                    AbstractAuthenticationToken authenticationToken = UsernamePasswordAuthenticationToken.authenticated(
                        authentication, token, authentication.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    chain.doFilter(request, response);
                } else {
                    throw new InvalidTokenException("Invalid Token");
                }
            } else {
                throw new TokenNotFoundException("Token Not Found");
            }
        } catch (ExpiredJwtException e) {
            throw new UnexpectedSecurityException("Token Expired");
        } catch (SignatureException e) {
            throw new UnexpectedSecurityException("TOKEN SignatureException Login");
        } catch (JwtException e) {
            throw new UnexpectedSecurityException("TOKEN Parsing JwtException");
        } catch (Exception e) {
            throw new UnexpectedSecurityException("Unexpected Exception");
        }
    }

    /**
     * 토큰 관련된 Exception 발생 시 예외 응답
     */
//    private JSONObject jsonResponseWrapper(Exception e) {
//        String resultMsg = "";
//        if (e instanceof ExpiredJwtException) {
//            resultMsg = "Token Expired";
//        } else if (e instanceof SignatureException) {
//            resultMsg = "TOKEN SignatureException Login";
//        }
//        // JWT 토큰내에서 오류 발생 시
//        else if (e instanceof JwtException) {
//            resultMsg = "TOKEN Parsing JwtException";
//        }
//        // 이외 JTW 토큰내에서 오류 발생
//        else {
//            resultMsg = "OTHER TOKEN ERROR";
//        }
//
//        HashMap<String, Object> jsonMap = new HashMap<>();
//        jsonMap.put("status", 401);
//        jsonMap.put("message", resultMsg);
//        jsonMap.put("reason", e.getMessage());
//        return new JSONObject(jsonMap);
//    }
}
