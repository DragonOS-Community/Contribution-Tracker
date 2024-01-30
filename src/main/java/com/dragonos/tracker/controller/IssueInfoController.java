package com.dragonos.tracker.controller;

import com.dragonos.tracker.service.IssueInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * issue信息表 前端控制器
 * </p>
 *
 * @author yummy
 */
@Slf4j
@RestController
@RequestMapping("issueInfo")
public class IssueInfoController {
    @Autowired
    private IssueInfoService issueInfoService;
}
