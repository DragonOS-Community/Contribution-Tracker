package com.dragonos.tracker.controller;

import com.dragonos.tracker.service.ContributorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 个人贡献表 前端控制器
 * </p>
 *
 * @author yummy
 */
@Slf4j
@RestController
@RequestMapping("contributor")
public class ContributorController {

    @Autowired
    private ContributorService contributorService;
}
