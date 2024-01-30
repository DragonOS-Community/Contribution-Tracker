package com.dragonos.tracker.controller;
import com.dragonos.tracker.service.CertificateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 证书信息 前端控制器
 * </p>
 *
 * @author yummy
 */
@Slf4j
@RestController
@RequestMapping("certificate")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;
}
