package com.ssafy.place.controller;

import static java.io.File.separator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.place.model.dto.PlaceDto;
import com.ssafy.place.model.service.PlaceService;


@RestController
@RequestMapping("/place")
@CrossOrigin("*")
public class PlaceController {
	private final Logger logger = LoggerFactory.getLogger(PlaceController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private PlaceService placeService;

	public PlaceController(PlaceService placeService) {
		this.placeService = placeService;
	}

	@GetMapping
	public ResponseEntity<?> place() throws Exception {
		List<PlaceDto> placeList = placeService.placeList();
		if (placeList != null && !placeList.isEmpty()) {
			return new ResponseEntity<List<PlaceDto>>(placeList, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<?> getQna(@PathVariable("no") String no) throws Exception{
		
		if(placeService.updateHit(no) == 0) return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		PlaceDto placeDto = placeService.getPlace(no);
		if(placeDto != null) {
			return new ResponseEntity<PlaceDto>(placeDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}

	@Value("${upload.path}")
	private String uploadPath;
	
	@PostMapping(consumes = "multipart/form-data")
	public ResponseEntity<String> WritePlace(
	        @RequestParam("file") MultipartFile file,
	        @RequestParam("no") String no,
	        @RequestParam("lat") String lat,
	        @RequestParam("lon") String lon,
	        @RequestParam("title") String title,
	        @RequestParam("content") String content,
	        @RequestParam("date") String date,
	        @RequestParam("userId") String userId) throws Exception {
		String image = null;

		String RESOURCE_PATH =
			      new ClassPathResource(uploadPath).getPath() + separator;
		if (!file.isEmpty()) {
			System.out.println(RESOURCE_PATH);
			String fileName = file.getOriginalFilename(); // 업로드된 파일명
	        Path filePath = Paths.get(RESOURCE_PATH, fileName); // 저장할 경로 설정
	        Files.createDirectories(filePath.getParent()); // 부모 디렉토리가 존재하지 않으면 생성
	        file.transferTo(filePath); // 파일 저장
	        image = filePath.toString().split("uploads\\\\")[1]; // 파일 경로 저장
        }
		PlaceDto placeDto = new PlaceDto(no, lat, lon, title, content, date, image, new MemberDto(userId));
				
		if(placeService.createPlace(placeDto) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{no}")
	public ResponseEntity<?> modifyPlace(@PathVariable("no") String no, @RequestParam("file") MultipartFile file,
	        @RequestParam("lat") String lat,
	        @RequestParam("lon") String lon,
	        @RequestParam("title") String title,
	        @RequestParam("content") String content,
	        @RequestParam("date") String date,
	        @RequestParam("userId") String userId) throws Exception {
		String image = placeService.getImage(no);
		String RESOURCE_PATH =
			      new ClassPathResource(uploadPath).getPath() + separator;
		try {
          Path filePath = Paths.get(RESOURCE_PATH, image);
          Files.deleteIfExists(filePath); // 파일 삭제
      } catch (IOException e) {
          // 파일 삭제 실패
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
		RESOURCE_PATH =
			      new ClassPathResource(uploadPath).getPath() + separator;
		if (!file.isEmpty()) {
			System.out.println(RESOURCE_PATH);
			String fileName = file.getOriginalFilename(); // 업로드된 파일명
	        Path filePath = Paths.get(RESOURCE_PATH, fileName); // 저장할 경로 설정
	        Files.createDirectories(filePath.getParent()); // 부모 디렉토리가 존재하지 않으면 생성
	        file.transferTo(filePath); // 파일 저장
	        image = filePath.toString().split("uploads\\\\")[1]; // 파일 경로 저장
        }
		PlaceDto placeDto = new PlaceDto(no, lat, lon, title, content, date, image, new MemberDto(userId));
		if (placeService.updatePlace(placeDto) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{no}")
	public ResponseEntity<?> deletePlace(@PathVariable("no") String no) throws Exception{
		
		String image = placeService.getImage(no);
		String RESOURCE_PATH =
			      new ClassPathResource(uploadPath).getPath() + separator;
		try {
            Path filePath = Paths.get(RESOURCE_PATH, image);
            Files.deleteIfExists(filePath); // 파일 삭제
        } catch (IOException e) {
            // 파일 삭제 실패
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
		if (placeService.deletePlace(no) != 0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
