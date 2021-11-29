package com.misiontic2022.apichiquitines.util;


import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "file")
public class RecursosFileStorageProperties {
	

	private String uploadDir;

	public String getUploadDir() {
		return uploadDir+"/"+"ArchivosProfesores";
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}	
}
