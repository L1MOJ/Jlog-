package com.limoj.jlog.controller;

import com.limoj.jlog.domain.ResponseResult;
import com.limoj.jlog.service.DonatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="donator", description = "the Donator API")
@RequestMapping("/support")
public class DonatorController {
    @Autowired
    private DonatorService donatorService;
    @Operation(summary = "Get donators in pages")
    @GetMapping("/donators")
    public ResponseResult getDonators(Integer pageNum, Integer pageSize) {
        return donatorService.getDonators(pageNum,pageSize);
    }

}
