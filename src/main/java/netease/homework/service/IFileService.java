package netease.homework.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Author SMJ
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
