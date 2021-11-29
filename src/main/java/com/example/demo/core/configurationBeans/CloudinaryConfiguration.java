package com.example.demo.core.configurationBeans;

import java.util.HashMap;
import java.util.Map;

import com.cloudinary.Cloudinary;

public class CloudinaryConfiguration {

    private static Map<String,String> variables = new HashMap<String,String>();

    public static Cloudinary buildConnection(){
        variables.put("cloudinary.cloud_name", System.getenv("cloud_name"));
        variables.put("cloudinary.api_key", System.getenv("api_key"));
        variables.put("cloudinary.api_secret", System.getenv("api_secret"));
        Cloudinary cloudinary = new Cloudinary(variables);
        return cloudinary;
    }
}