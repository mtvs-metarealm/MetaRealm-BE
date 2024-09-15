package com.metarealm.metarealm_be.security.auth.handler;

import com.metarealm.metarealm_be.security.auth.model.DetailsUser;
import com.metarealm.metarealm_be.security.common.AuthConstants;
import com.metarealm.metarealm_be.security.common.utils.TokenUtils;
import com.metarealm.metarealm_be.security.user.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
public class CustomAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException /*, ServletException */ {
        User user = ((DetailsUser) authentication.getPrincipal()).getUser();
//        JSONObject jsonValue = (JSONObject) ConvertUtil.convertObjectToJsonObject(user); // XR 요청에 따라 지움
        HashMap<String, Object> responseMap = new HashMap<>();

        JSONObject jsonObject;
        if (user.getState().equals("N")) {
//            responseMap.put("userInfo", jsonValue); // XR 요청에 따라 지움
            responseMap.put("message", "This account is dormant"); // 휴면 계정 상태일 때
        } else {
            String token = TokenUtils.generateJwtToken(user);
//            responseMap.put("userInfo", jsonValue); // XR 요청에 따라 지움
            responseMap.put("message", "Successes to login");

            response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_TYPE + " " + token);
            responseMap.put("token", AuthConstants.TOKEN_TYPE + " " + token);
        }

        jsonObject = new JSONObject(responseMap);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(jsonObject);
        printWriter.flush();
        printWriter.close();
    }
}
