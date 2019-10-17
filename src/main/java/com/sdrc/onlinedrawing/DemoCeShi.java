package com.sdrc.onlinedrawing;

import com.sdrc.onlinedrawing.util.JwtUtil;

import java.io.UnsupportedEncodingException;

public class DemoCeShi {
    public static void main(String[] args) {
        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzEyOTMxNjMsInVzZXJuYW1lIjoidXNlciJ9.xGZLA52c8rNmbpZDL3mpxUIcNBdC_pvtaO6qaclUxPQ
        try {
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzEyOTMxNjMsInVzZXJuYW1lIjoidXNlciJ9.xGZLA52c8rNmbpZDL3mpxUIcNBdC_pvtaO6qaclUxPQ";
            String token1 = JwtUtil.getUsername(token);
            boolean expires = JwtUtil.isExpires(token);
            System.out.println(token);
            System.out.println(token1);
            System.out.println(expires);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
