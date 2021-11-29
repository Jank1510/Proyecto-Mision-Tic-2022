package com.misiontic2022.apichiquitines.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class NoticiasFileStorageProperties {

	private String uploadDir;

	public String getUploadDir() {
		return uploadDir+"/"+"Noticias";
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}	
}
