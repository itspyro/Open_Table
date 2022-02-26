package com.example.opentable.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.opentable.repository.dao.PhotoDao;
import com.example.opentable.service.PhotoService;
import com.example.opentable.transport.dto.CreatePhotoDto;
import com.example.opentable.transport.dto.PhotoDto;

@Service
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired
	PhotoDao photoDao;
	
	
	@Override
	public List<PhotoDto> getAllPhotos() throws Exception {
		return photoDao.getAllPhotos();
	}

	@Override
	public List<PhotoDto> getPhotoById(int photoId) throws Exception {
		
		return photoDao.getPhotoById(photoId);
	}

	@Override
	public List<PhotoDto> getRestaurantPhoto(int restaurantId) throws Exception {
		return photoDao.getRestaurantPhoto(restaurantId);
	}

	@Override
	public int createPhoto(CreatePhotoDto photoDto) throws Exception {
		return photoDao.createPhoto(photoDto);
	}

	@Override
	public int deletePhoto(int photoId) throws Exception {
		return photoDao.deletePhoto(photoId);
	}
	
	@Override
	public String uploadFile(CreatePhotoDto photoDto, MultipartFile file) throws Exception{
			
	        Path uploadPath = Paths.get("./src/main/resources/static/images");
	         System.out.print(""+uploadPath);
	        if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }
	        String filename = StringUtils.cleanPath(file.getOriginalFilename());
            filename = filename.toLowerCase().replaceAll(" ", "-");
            System.out.print(file.getOriginalFilename());
	        try (InputStream inputStream = file.getInputStream()) {
	        	
	            Path filePath = uploadPath.resolve(filename);
	            System.out.print(""+filePath.toFile().getAbsolutePath());
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	            String photoUrl = filePath.toFile().getAbsolutePath();
	            String r="";
	            System.out.print(photoUrl);
	            boolean f=false;
	            for(int i=0;i<photoUrl.length();i++) {
	            	System.out.print("jnc");
	            	if(!f && photoUrl.charAt(i)=='.'&& photoUrl.charAt(i+1)=='/') {
	            		i+=1;
	            		f=true;
	            	}
	            	else {
	            		r+=photoUrl.charAt(i);
	            	}
	            }
	            photoUrl =r;
	            photoDto.setPhotoUrl(photoUrl);
	            photoDao.createPhoto(photoDto);
	            return photoUrl;
	        } 
	        catch (IOException ioe) {       
	            throw new IOException("Could not save image file: " + file.getOriginalFilename(), ioe);
	        } 
	        catch(Exception e) {
	        	throw e;
	        }
//		return true;
	}

}
