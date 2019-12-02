package com.phion.tmall.config;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.phion.tmall.util.FileUtil;

@Configuration
public class ResourceConfigAdapter extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 获取文件的真实路径
		String path = FileUtil.getResourcesPath()+"static\\img\\";
		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("win")) {
			System.out.println("file:"+path);
			registry.addResourceHandler("/img/**").addResourceLocations("file:" + path);
		} else {// linux和mac系统 可以根据逻辑再做处理
			registry.addResourceHandler("/img/**").addResourceLocations("file:" + path);
		}
		super.addResourceHandlers(registry);
	}
	
	
	
}